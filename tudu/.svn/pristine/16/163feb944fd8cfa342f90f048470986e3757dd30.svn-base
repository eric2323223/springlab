package tudu.web.dwr.impl;

import static org.easymock.EasyMock.*;

import tudu.domain.model.TodoList;
import tudu.domain.model.User;
import tudu.service.TodoListsManager;
import tudu.service.UserManager;
import junit.framework.TestCase;

public class TodoListsDwrImplTest extends TestCase {

    TodoList todoList = new TodoList();
    
    TodoListsManager todoListsManager = null;
    UserManager userManager = null;
       
    TodoListsDwrImpl todoListsDwr = new TestableTodoListsDwrImpl();
    
    public void setUp() {
        todoList.setListId("001");
        todoList.setName("Description");
        todoList.setRssAllowed(false);
        
        todoListsManager = (TodoListsManager) createMock(TodoListsManager.class);
        
        userManager = (UserManager) createMock(UserManager.class);
        
        todoListsDwr.setTodoListsManager(todoListsManager);
        todoListsDwr.setUserManager(userManager);
    }
    
    public void tearDown() {
        verify(todoListsManager);
        verify(userManager);
    }
    
    private void replay_() {
        replay(todoListsManager);
        replay(userManager);
    }
    
    public void testGetTodoListName() {
         expect(todoListsManager.findTodoList("001")).andReturn(todoList);
         
         replay_();
         
         String name = todoListsDwr.getTodoListName("001");
         assertEquals("Description", name);
    }
    
    public void testGetTodoListRss() {
        todoList.setRssAllowed(true);
        expect(todoListsManager.findTodoList("001")).andReturn(todoList);
        
        replay_();
        
        String rss = todoListsDwr.getTodoListRss("001");
        assertEquals("1", rss);
    }
    
    public void testGetTodoListRss2() {
        todoList.setRssAllowed(false);
        expect(todoListsManager.findTodoList("001")).andReturn(todoList);
        
        replay_();
        
        String rss = todoListsDwr.getTodoListRss("001");
        assertEquals("0", rss);
    }
    
    public void testGetTodoListUsers() {
        User user = new User();
        user.setLogin("test_user");
        expect(userManager.getCurrentUser()).andReturn(user);
        
        todoList.getUsers().add(user);
        
        User user1 = new User();
        user1.setLogin("BBB");
        todoList.getUsers().add(user1);
        
        User user2 = new User();
        user2.setLogin("AAA");
        todoList.getUsers().add(user2);
        
        User user3 = new User();
        user3.setLogin("CCC");
        todoList.getUsers().add(user3);
        
        expect(todoListsManager.findTodoList("001")).andReturn(todoList);
        
        replay_();
        
        String[] logins = todoListsDwr.getTodoListUsers("001");
        
        assertEquals(3, logins.length);
        assertEquals("AAA", logins[0]);
        assertEquals("BBB", logins[1]);
        assertEquals("CCC", logins[2]);
    }
    
    public void testAddTodoListUser() {
        todoListsManager.addTodoListUser("001", "test_user");
        
        replay_();
        
        todoListsDwr.addTodoListUser("001", "test_user");
    }
    
    public void testDeleteTodoListUser() {
        todoListsManager.deleteTodoListUser("001", "test_user");
        
        replay_();
        
        todoListsDwr.deleteTodoListUser("001", "test_user");
    }
    
    public void testEditTodoListName() {
        expect(todoListsManager.findTodoList("001")).andReturn(todoList);
        todoListsManager.updateTodoList(todoList);
        
        replay_();
        
        todoListsDwr.editTodoListName("001", "edit name");
        
        assertEquals("edit name", todoList.getName());
    }
}
