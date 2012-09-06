package org.springside.examples.showcase.common.dao;

import java.io.Serializable;

import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.UUIDHexGenerator;

/**
 * 继承Hibernate的UUIDGenerator, 将GUID长度缩短到15位.
 * UUID主要用于同时使用多个数据库,不能依赖单个数据库自增生成主键的情形.
 * 
 * 1. AppId   - 使用2位的自定义值代替 原UUID中的IP(8位) + 同一IP上的JVM(8位),节约14位 
 * 2. 时间戳      - 沿用原算法.
 * 3. Count   - 相同JVM同一毫秒内的计数器,长度减为2.
 *
 * 全部使用Hex编码, 2位AppId + 12位时间戳   + 2位微秒内计数器.

 * @author calvin
 */
public class UIDGenerator extends UUIDHexGenerator {

	@Override
	public Serializable generate(SessionImplementor session, Object object) {
		return new StringBuilder(16).append(formatShort(getAppId())).append(format(getHiTime())).append(
				format(getLoTime())).append(formatShort(getCount())).toString();
	}

	/**
	 * 可重载子类实现从System Properties, Spring ApplicationContext等地方获得值.
	 */
	protected short getAppId() {
		return 0;
	}

	/**
	 * 格式化最大值为255的数值成长度为2的字符串.
	 */
	protected String formatShort(short value) {
		String formatted = Integer.toHexString(value);
		if (formatted.length() < 2) {
			formatted = "0" + formatted;
		}
		return formatted;
	}
}
