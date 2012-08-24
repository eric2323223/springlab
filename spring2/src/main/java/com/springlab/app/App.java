package com.springlab.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SampleService service = context
    }
}
