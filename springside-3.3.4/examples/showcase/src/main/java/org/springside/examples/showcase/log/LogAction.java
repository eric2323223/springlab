package org.springside.examples.showcase.log;

import org.apache.struts2.convention.annotation.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springside.examples.showcase.log.trace.TraceUtils;
import org.springside.examples.showcase.log.trace.Traced;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 演示向数据库写入日志的Action.
 * 
 * @author calvin
 */
@Namespace("/log")
public class LogAction extends ActionSupport {

	private static final long serialVersionUID = 3331334076147567129L;
	/**
	 * 在log4j.properties中,本logger已被指定使用asyncAppender.
	 */
	public static final String DB_LOGGER_NAME = "DBLogExample";

	@Override
	public String execute() {
		logDB();
		logTrace();
		logAop(1);
		return SUCCESS;
	}

	private void logDB() {
		Logger logger = LoggerFactory.getLogger(DB_LOGGER_NAME);
		logger.info("helloworld!!");
	}

	private void logTrace() {
		Logger logger = LoggerFactory.getLogger(LogAction.class);

		TraceUtils.beginTrace();
		logger.debug("Hello, a debug message");
		TraceUtils.endTrace();
	}

	@Traced
	private int logAop(int i) {
		return i;
	}
}
