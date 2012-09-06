/**
 * Copyright (c) 2005-2010 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: SpringTxTestCase.java 1215 2010-09-12 04:14:26Z calvinxiu $
 */
package org.springside.modules.test.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Spring的支持数据库访问,事务控制和依赖注入的JUnit4 集成测试基类,相比Spring原基类名字更短.
 *   
 * 子类需要定义applicationContext文件的位置, 如:
 * @ContextConfiguration(locations = { "/applicationContext-test.xml" })
 * 
 * @author calvin
 */
public abstract class SpringTxTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	protected DataSource dataSource;

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
	}
}
