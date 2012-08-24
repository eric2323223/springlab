package tudu.web;

public class ShowTodoListsActionTest extends TuduBaseMockStrutsTestCase {

    public void testDisplay() {
        setRequestPathInfo("/secure/showTodoLists");
        request.setRemoteUser("admin");
        actionPerform();
        verifyForward("show");
    }
}
