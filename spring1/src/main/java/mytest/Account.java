package mytest;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/22/12
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */

public class Account {
    String AccountOwner;
    int balance;
    String accountId;
    AccountStatus status;

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public enum AccountStatus{OK, BANNED, SUSPICIOUS}

    public Account(String accountOwner, int balance, String accountId) {
        AccountOwner = accountOwner;
        this.balance = balance;
        this.accountId = accountId;
    }

    public String getAccountId() {

        return accountId;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountOwner() {
        return AccountOwner;
    }

    public void setBalance(int a) {
        this.balance = a;
    }
}
