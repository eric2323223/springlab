package mytest;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/23/12
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class AccountServiceTest {
    private AccountService service;
    Account account = new Account("Eric", 100, "123");

    @Before
    public void setUp() throws Exception {
        service = new AccountService();

    }

    @Test
    public void testDeposite1() throws Exception {
        service.deposite(account, 50);
        assertEquals(150, account.getBalance());
    }

    @Test(expected = AccountBannedException.class)
    public void testDeposite2() throws Exception {
        account.setStatus(Account.AccountStatus.BANNED);
        service.deposite(account, 50);
    }

    @Test
    public void testWithdraw() throws Exception {
        service.withdraw(account, 50);
        assertEquals(50, account.getBalance());
    }

    @Test(expected = OverWithdrawException.class)
    public void testOverWithdraw() throws Exception {
        service.withdraw(account, 200);
    }

    @Test(expected = AccountBannedException.class)
    public void testWithdrawBannedAccount() throws Exception {
        account.setStatus(Account.AccountStatus.BANNED);
        service.withdraw(account, 50);
    }
}
