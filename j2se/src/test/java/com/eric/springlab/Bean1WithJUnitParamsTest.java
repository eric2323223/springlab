package com.eric.springlab;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
public class Bean1WithJUnitParamsTest {

    private IBean1 bean1;

    @Before
    public void before()
    {
         bean1 = new Bean1();
    }

    /**
     * http://code.google.com/p/junitparams/
     */
    @Test
    @Parameters(method = "helloValues")
    public void testHello(String arg1, String arg2, String valid)
    {
        System.out.println(getClass().getName() + ".testHello");
        //given
        bean1.setVar1(arg1);
        String result;
        //when

        result = bean1.hello(arg2);

        //then
        assertThat(result).isEqualTo(valid);

    }

    private Object[] helloValues() {
        return $(
                    $("Hello", "word1", "Hello, word1"),
                    $("Hello", "word2", "Hello, word2")
                );
    }

    public static Object[] $(Object... params)
    {
        return params;
    }
}
