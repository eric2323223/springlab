package mytest;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/23/12
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Service2Test {
    private Account account2;
    private Account account1;
    private Service1 service;

    @Before
    public void setup() {
        service = new Service1(new AccountService());
        account1 = new Account("Eric", 100, "123");
        account2 = new Account("Eric", 100, "121");
    }

    @Test
    public void testSuccessfulTransfer() throws Exception {
        service.transfer(account1, account2, 100);
        assertEquals(0, account1.getBalance());
        assertEquals(200, account2.getBalance());
    }

    @Test(expected = OverWithdrawException.class)
    public void testFailedTransfer() throws Exception {
        Account account = new Account("Dong", 50, "232");
        service.transfer(account, account1, 100);
    }
}
