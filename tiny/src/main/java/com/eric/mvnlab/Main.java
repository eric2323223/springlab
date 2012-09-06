package com.eric.mvnlab;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 30.11.11
 * Time: 17:20
 */
public class Main {
    public static void main(String[] args)
    {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:/META-INF/application-context-root.xml");
        IRunner runner = ctx.getBean("runner", IRunner.class);
        runner.run();
    }
}
