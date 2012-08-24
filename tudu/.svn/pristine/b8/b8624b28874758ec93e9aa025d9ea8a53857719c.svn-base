package tudu.service.impl;

import junit.framework.TestCase;

import static org.easymock.EasyMock.*;

import tudu.domain.RolesEnum;
import tudu.domain.dao.RoleDAO;
import tudu.domain.dao.TodoDAO;
import tudu.domain.dao.TodoListDAO;
import tudu.domain.dao.UserDAO;
import tudu.domain.model.Role;
import tudu.domain.model.Todo;
import tudu.domain.model.TodoList;
import tudu.domain.model.User;
import tudu.service.UserAlreadyExistsException;

public class UserManagerImplTest extends TestCase {

    User user = new User();
    
    UserDAO userDAO = null;
    RoleDAO roleDAO = null;
    TodoListDAO todoListDAO = null;
    TodoDAO todoDAO = null;
        
    UserManagerImpl userManager = new UserManagerImpl();
    
    public void setUp() {
        user.setLogin("test_user");
        user.setFirstName("First name");
        user.setLastName("Last name");
        
        userDAO = (UserDAO) createMock(UserDAO.class);
        roleDAO = (RoleDAO) createMock(RoleDAO.class);
        todoListDAO = (TodoListDAO) createMock(TodoListDAO.class);
        todoDAO = (TodoDAO) createMock(TodoDAO.class);
        
        userManager.setUserDAO(userDAO);
        userManager.setRoleDAO(roleDAO);
        userManager.setTodoListDAO(todoListDAO);
        userManager.setTodoDAO(todoDAO);
    }
    
    public void tearDown() {
        verify(userDAO);
        verify(roleDAO);
        verify(todoListDAO);
        verify(todoDAO);
    }
    
    private void replay_() {
        replay(userDAO);
        replay(roleDAO);
        replay(todoListDAO);
        replay(todoDAO);
    }
    
    public void testFindUser() {
        expect(userDAO.getUser("test_user")).andReturn(user);
        
        replay_();
        
        User testUser = userManager.findUser("test_user");
        assertEquals(testUser, user);
    }
    
    public void testUpdateUser() {
        userDAO.updateUser(user);
        
        replay_();
        
        userManager.updateUser(user);
    }
    
    public void testCreateUser() {
        expect(userDAO.getUser("test_user")).andReturn(null);
        
        Role role = new Role();
        role.setRole(RolesEnum.ROLE_USER.toString());
        expect(roleDAO.getRole(RolesEnum.ROLE_USER.toString())).andReturn(role);
        
        userDAO.saveUser(user);
        
        TodoList todoList = new TodoList();
        todoListDAO.saveTodoList(todoList);
        
        Todo todo = new Todo();
        todoDAO.saveTodo(todo);
        todoListDAO.updateTodoList(todoList);
        
        replay_();
        
        try {
            userManager.createUser(user);
            assertTrue(user.isEnabled());
            assertNotNull(user.getCreationDate());
            assertNotNull(user.getLastAccessDate());
            assertEquals(1, user.getRoles().size());
            Role testRole = user.getRoles().iterator().next();
            assertEquals(RolesEnum.ROLE_USER.toString(), testRole.getRole());
            assertEquals(1, user.getTodoLists().size());
            TodoList testTodoList = user.getTodoLists().iterator().next();
            assertNotNull(testTodoList.getLastUpdate());
            assertEquals(1, testTodoList.getTodos().size());
        } catch (UserAlreadyExistsException e) {
            fail("A UserAlreadyExistsException should not have been thrown.");
        }
    }
    
    public void testFailedCreateUser() {
        expect(userDAO.getUser("test_user")).andReturn(user);
        
        replay_();
        
        try {
            userManager.createUser(user);
            fail("A UserAlreadyExistsException should have been thrown.");
        } catch (UserAlreadyExistsException e) {
            
        }
    }
}
