package mytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/22/12
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class Service2 {

    @Autowired
    AccountService accountService;

    @Autowired
    public Service2(AccountService service){
        accountService = service;
    }

    public String getResult() {
        return "result from service2";
    }


}
