package com.springlab.app;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowire;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/22/12
 * Time: 2:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SampleService {

    @Autowire
    Service2 service2;

    public void printResult(){
        System.out.println(service2.getResult());
    }

}
