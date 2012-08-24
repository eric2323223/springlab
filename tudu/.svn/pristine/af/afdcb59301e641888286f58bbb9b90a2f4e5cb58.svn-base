package tudu.security;

import junit.framework.TestCase;

import org.acegisecurity.userdetails.UserDetails;
import static org.easymock.EasyMock.*;
import tudu.domain.RolesEnum;
import tudu.domain.model.Role;
import tudu.domain.model.User;
import tudu.service.UserManager;

public class UserDetailsServiceImplTest extends TestCase {

    public void testLoadUserByUsername() {
        UserDetailsServiceImpl authenticationDAO = new UserDetailsServiceImpl();
        UserManager userManager = (UserManager) createMock(UserManager.class);
        authenticationDAO.setUserManager(userManager);
        
        User user = new User();
        user.setLogin("test_user");
        user.setPassword("password");
        user.setEnabled(true);
        Role userRole = new Role();
        userRole.setRole(RolesEnum.ROLE_USER.toString());
        user.getRoles().add(userRole);
        expect(userManager.findUser("test_user")).andReturn(user);
        
        userManager.updateUser(user);
        
        replay(userManager);
        
        UserDetails acegiUser = authenticationDAO.loadUserByUsername("test_user");
        
        assertEquals(user.getLogin(), acegiUser.getUsername());
        assertEquals(user.getPassword(), acegiUser.getPassword());
        assertNotNull(user.getLastAccessDate());
        assertEquals(1, acegiUser.getAuthorities().length);
        assertEquals(RolesEnum.ROLE_USER.toString(), acegiUser.getAuthorities()[0].getAuthority());
        
        verify(userManager);
    }
}
