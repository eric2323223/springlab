package org.springside.examples.showcase.unit.schedule;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springside.examples.showcase.schedule.QuartzClusterableJob;
import org.springside.modules.log.MockLog4jAppender;
import org.springside.modules.test.spring.SpringTxTestCase;
import org.springside.modules.test.utils.DbUnitUtils;
import org.springside.modules.utils.ThreadUtils;

/**
 * Quartz可集群Timer Job测试.
 * 
 * @author calvin
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-test.xml",
		"/schedule/applicationContext-quartz-timer-cluster.xml" })
@TransactionConfiguration(transactionManager = "defaultTransactionManager")
public class QuartzClusterableJobTest extends SpringTxTestCase {

	@Test
	public void scheduleJob() throws Exception {
		DbUnitUtils.loadData(dataSource, "/data/default-data.xml");

		//加载测试用logger appender
		MockLog4jAppender appender = new MockLog4jAppender();
		appender.addToLogger(QuartzClusterableJob.class);

		//等待任务启动
		ThreadUtils.sleep(3000);

		//验证任务已执行
		assertEquals(1, appender.getAllLogs().size());

		assertEquals("There are 6 user in database, print by default's job.", appender.getFirstLog().getMessage());

		DbUnitUtils.removeData(dataSource, "/data/default-data.xml");
	}
}
