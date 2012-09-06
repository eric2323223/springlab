package org.springside.examples.showcase.common.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.showcase.cache.MemcachedObjectType;
import org.springside.examples.showcase.common.dao.UserDao;
import org.springside.examples.showcase.common.dao.UserJdbcDao;
import org.springside.examples.showcase.common.entity.User;
import org.springside.examples.showcase.jms.simple.NotifyMessageProducer;
import org.springside.examples.showcase.jmx.server.ServerConfig;
import org.springside.modules.memcached.SpyMemcachedClient;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;
import org.springside.modules.utils.encode.JsonBinder;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
//Spring Service Bean的标识.
@Component
public class AccountManager {
	private static Logger logger = LoggerFactory.getLogger(AccountManager.class);

	private UserDao userDao;

	private UserJdbcDao userJdbcDao;

	private SpyMemcachedClient spyMemcachedClient;

	private JsonBinder jsonBinder = JsonBinder.buildNonDefaultBinder();

	private ServerConfig serverConfig; //系统配置

	private NotifyMessageProducer notifyProducer; //JMS消息发送

	private PasswordEncoder encoder = new ShaPasswordEncoder();

	/**
	 * 在保存用户时,发送用户修改通知消息, 由消息接收者异步进行较为耗时的通知邮件发送.
	 * 
	 * 如果企图修改超级用户,取出当前操作员用户,打印其信息然后抛出异常.
	 * 
	 */
	//演示指定非默认名称的TransactionManager.
	@Transactional("defaultTransactionManager")
	public void saveUser(User user) {

		if (isSupervisor(user)) {
			logger.warn("操作员{}尝试修改超级管理员用户", SpringSecurityUtils.getCurrentUserName());
			throw new ServiceException("不能修改超级管理员用户");
		}

		String shaPassword = encoder.encodePassword(user.getPlainPassword(), null);
		user.setShaPassword(shaPassword);

		userDao.save(user);

		sendNotifyMessage(user);
	}

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(User user) {
		return (user.getId() != null && "1".equals(user.getId()));
	}

	@Transactional(readOnly = true)
	public User getUser(String id) {
		return userDao.get(id);
	}

	/**
	 * 取得用户, 并对用户的延迟加载关联进行初始化.
	 */
	@Transactional(readOnly = true)
	public User getInitedUser(String id) {
		if (spyMemcachedClient != null) {
			return getUserFromMemcached(id);
		} else {
			return userJdbcDao.queryObject(id);
		}
	}

	/**
	 * 访问Memcached, 使用JSON字符串存放对象以节约空间.
	 */
	private User getUserFromMemcached(String id) {

		String key = MemcachedObjectType.USER.getPrefix() + id;

		User user = null;
		String jsonString = spyMemcachedClient.get(key);

		if (jsonString == null) {
			//用户不在 memcached中,从数据库中取出并放入memcached.
			//因为hibernate的proxy问题多多,此处使用jdbc
			user = userJdbcDao.queryObject(id);
			if (user != null) {
				jsonString = jsonBinder.toJson(user);
				spyMemcachedClient.set(key, MemcachedObjectType.USER.getExpiredTime(), jsonString);
			}
		} else {
			user = jsonBinder.fromJson(jsonString, User.class);
		}
		return user;
	}

	/**
	 * 按名称查询用户, 并对用户的延迟加载关联进行初始化.
	 */
	@Transactional(readOnly = true)
	public User searchLoadedUserByName(String name) {
		User user = userDao.findUniqueBy("name", name);
		userDao.initUser(user);
		return user;
	}

	/**
	 * 取得所有用户, 预加载用户的角色.
	 */
	@Transactional(readOnly = true)
	public List<User> getAllUserWithRole() {
		List<User> list = userDao.getAllUserWithRoleByDistinctHql();
		logger.info("get {} user sucessful.", list.size());
		return list;
	}

	/**
	 * 获取当前用户数量.
	 */
	@Transactional(readOnly = true)
	public Long getUserCount() {
		return userDao.getUserCount();
	}

	@Transactional(readOnly = true)
	public User findUserByLoginName(String loginName) {
		return userDao.findUniqueBy("loginName", loginName);
	}

	/**
	 * 批量修改用户状态.
	 */
	public void disableUsers(List<String> ids) {
		userDao.disableUsers(ids);
	}

	/**
	 * 发送用户变更消息.
	 * 
	 * 同时发送只有一个消费者的Queue消息与发布订阅模式有多个消费者的Topic消息.
	 */
	private void sendNotifyMessage(User user) {
		if (serverConfig != null && serverConfig.isNotificationMailEnabled() && notifyProducer != null) {
			try {
				notifyProducer.sendQueue(user);
				notifyProducer.sendTopic(user);
			} catch (Exception e) {
				logger.error("消息发送失败", e);
			}
		}
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setUserJdbcDao(UserJdbcDao userJdbcDao) {
		this.userJdbcDao = userJdbcDao;
	}

	@Autowired(required = false)
	public void setServerConfig(ServerConfig serverConfig) {
		this.serverConfig = serverConfig;
	}

	@Autowired(required = false)
	public void setNotifyProducer(NotifyMessageProducer notifyProducer) {
		this.notifyProducer = notifyProducer;
	}

	@Autowired(required = false)
	public void setSpyMemcachedClient(SpyMemcachedClient spyMemcachedClient) {
		this.spyMemcachedClient = spyMemcachedClient;
	}
}
