package mytest;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/22/12
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AccountDAO {

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("Eric", 100, "1234567890"))    ;
        accounts.add(new Account("Jim", 100, "1243234223"));
        accounts.add(new Account("Jason", 500, "2322314322"));

        return accounts;
    }

    public Account getAccount(String id) {
        for (Account account : getAllAccounts()) {
            if (account.getAccountId().equals(id)) {
                return account;
            }
        }
        return null;
    }


}
