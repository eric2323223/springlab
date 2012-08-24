package tudu.web;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.context.SecurityContextImpl;
import org.acegisecurity.providers.TestingAuthenticationToken;
import org.acegisecurity.userdetails.User;

public class ShowTodosActionTest extends TuduBaseMockStrutsTestCase {

    protected void setUp() throws Exception {
        super.setUp();
        SecurityContextImpl ctx = new SecurityContextImpl();
        GrantedAuthority authority = new GrantedAuthority() {

            public String getAuthority() {
                return "ROLE_ADMIN";
            }

        };
        User user = new User("admin", "admin", true, true, true, false,
                new GrantedAuthority[] { authority });
        TestingAuthenticationToken token = new TestingAuthenticationToken(user,
                null, new GrantedAuthority[] { authority });
        ctx.setAuthentication(token);
        SecurityContextHolder.setContext(ctx);
    }

    public void testDisplay() {
        setRequestPathInfo("/secure/showTodos");
        addRequestParameter("listId", "ff808081085e18fc01085e19a3820002");
        actionPerform();
        verifyForward("show");
    }
}
