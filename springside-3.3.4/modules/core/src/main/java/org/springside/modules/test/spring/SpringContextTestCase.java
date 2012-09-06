/**
 * Copyright (c) 2005-2010 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: SpringContextTestCase.java 1210 2010-09-10 16:13:27Z calvinxiu $
 */
package org.springside.modules.test.spring;

import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Spring的支持依赖注入的JUnit4 集成测试基类, 相比Spring原基类名字更短.
 * 
 * 子类需要定义applicationContext文件的位置,如:
 * @ContextConfiguration(locations = { "/applicationContext-test.xml" })
 * 
 * @author calvin
 */
public abstract class SpringContextTestCase extends AbstractJUnit4SpringContextTests {
}
