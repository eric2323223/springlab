package com.eric.mvnlab;

import com.eric.mvnlab.util.ContextConfigurationTestRunner;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.fest.assertions.Assertions.assertThat;


public class Bean1IntegrateTest extends ContextConfigurationTestRunner{
    @Autowired
    private IBean1 bean1;

    @Test
    public void testHello()
    {
        System.out.println(getClass().getName() + ".testHello");
        //given
        String result;
        //when

        result = bean1.hello("integrate test");

        //then
        assertThat(result).isEqualTo("Hello, integrate test");
    }

}
