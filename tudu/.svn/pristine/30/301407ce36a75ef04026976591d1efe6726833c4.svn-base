package tudu.web;

public class MyInfoActionTest extends TuduBaseMockStrutsTestCase {

    public void testDisplay() {
        setRequestPathInfo("/secure/myInfo");
        request.setRemoteUser("admin");
        actionPerform();
        verifyForward("user.info");
    }
}
