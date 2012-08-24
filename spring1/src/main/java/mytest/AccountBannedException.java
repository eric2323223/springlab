package mytest;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/23/12
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class AccountBannedException extends Exception {

    public String getMessage() {
        return "Account#" + super.getMessage() + " is banned for any transaction";
    }
}
