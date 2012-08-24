package mytest;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/23/12
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class OverWithdrawException extends Exception {
    public String getMessage() {
        return "Ooops, over withdraw";
    }
}
