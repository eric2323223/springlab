package mytest;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/23/12
 * Time: 9:11 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AccountService {

    public void deposite(Account account, int amount)throws AccountBannedException{
        if (account.getStatus()== Account.AccountStatus.BANNED) {
            throw new AccountBannedException();
        }
        account.setBalance(account.getBalance() + amount);
    }

    public void withdraw(Account account, int amount) throws OverWithdrawException, AccountBannedException {
        if (account.getStatus() == Account.AccountStatus.BANNED) {
            throw new AccountBannedException();
        }
        if (account.getBalance() < amount) {
            throw new OverWithdrawException();
        }
        account.setBalance(account.getBalance() - amount);
    }
}
