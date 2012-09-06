package org.springside.modules.unit.log;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springside.modules.log.MockLog4jAppender;

public class MockLog4jAppenderTest {

	@Test
	public void normal() {
		String testString1 = "Hello";
		String testString2 = "World";
		MockLog4jAppender appender = new MockLog4jAppender();
		appender.addToLogger(MockLog4jAppenderTest.class);

		Logger logger = LoggerFactory.getLogger(MockLog4jAppenderTest.class);
		logger.warn(testString1);
		logger.warn(testString2);

		//getFirstLog/getLastLog
		assertEquals(testString1, appender.getFirstLog().getMessage());
		assertEquals(testString2, appender.getLastLog().getMessage());

		//getAllLogs
		assertEquals(2, appender.getAllLogs().size());
		assertEquals(testString2, appender.getAllLogs().get(1).getMessage());

		//clearLogs
		appender.clearLogs();
		assertNull(appender.getFirstLog());
		assertNull(appender.getLastLog());

	}

	@Test
	public void addAndRemoveAppender() {
		String testString = "Hello";
		Logger logger = LoggerFactory.getLogger(MockLog4jAppenderTest.class);
		MockLog4jAppender appender = new MockLog4jAppender();
		//class
		appender.addToLogger(MockLog4jAppenderTest.class);
		logger.warn(testString);
		assertNotNull(appender.getFirstLog());

		appender.clearLogs();
		appender.removeFromLogger(MockLog4jAppenderTest.class);
		logger.warn(testString);
		assertNull(appender.getFirstLog());

		//name
		appender.addToLogger("org.springside.modules.unit.log");
		logger.warn(testString);
		assertNotNull(appender.getFirstLog());

		appender.clearLogs();
		appender.removeFromLogger("org.springside.modules.unit.log");
		logger.warn(testString);
		assertNull(appender.getFirstLog());

	}
}
