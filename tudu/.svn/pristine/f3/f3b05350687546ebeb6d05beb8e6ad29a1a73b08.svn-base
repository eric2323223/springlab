package tudu.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;

import junit.framework.TestCase;

import static org.easymock.EasyMock.*;
import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import tudu.domain.dao.TodoDAO;
import tudu.domain.dao.TodoListDAO;
import tudu.domain.model.Todo;
import tudu.domain.model.TodoList;
import tudu.domain.model.User;
import tudu.security.PermissionDeniedException;
import tudu.service.UserManager;

public class TodoListsManagerImplTest extends TestCase {
    
    static String todoListBackup = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
        "<todolist>" + 
        " <title>test list</title>" +
        " <rss>true</rss>" +
        " <users>" +
        "  <user>test</user>" +
        " </users>" +
        " <todos>" +
        "  <todo id=\"0001\">" +
        "   <creationDate>1127860040000</creationDate>" +
        "   <description>test todo</description>" +
        "   <priority>10</priority>" +
        "   <completed>false</completed>" +
        "  </todo>" +
        " </todos>" + 
        "</todolist>";
    
    TodoList todoList = new TodoList();
    User user = new User();
    
    TodoListDAO todoListDAO = null;
    TodoDAO todoDAO = null;
    UserManager userManager = null;
     
    TodoListsManagerImpl todoListsManager = new TodoListsManagerImpl();
    
    public void setUp() {
        todoList.setListId("001");
        todoList.setName("Test Todo List");
        todoList.setRssAllowed(false);
        
        user.setLogin("test_user");
        user.setFirstName("First name");
        user.setLastName("Last name");
        
        todoListDAO = (TodoListDAO) createMock(TodoListDAO.class);
        userManager = (UserManager) createMock(UserManager.class);
        
        todoDAO = (TodoDAO) createMock(TodoDAO.class);
        
        todoListsManager.setTodoListDAO(todoListDAO);
        todoListsManager.setTodoDAO(todoDAO);
        todoListsManager.setUserManager(userManager);        
    }
    
    public void tearDown() {
        verify(todoListDAO);
        verify(todoDAO);
        verify(userManager);
    }
    
    private void replay_() {
        replay(todoListDAO);
        replay(todoDAO);
        replay(userManager);
    }

    public void testCreateTodoList() {
        todoListDAO.saveTodoList(todoList);
        
        expect(userManager.getCurrentUser()).andReturn(user);
        userManager.updateUser(user);
        
        replay_();
        
        todoListsManager.createTodoList(todoList);
        
        assertTrue(user.getTodoLists().contains(todoList));
    }
    
    public void testFindTodoList() {
        todoList.getUsers().add(user);
        user.getTodoLists().add(todoList);
        
        expect(todoListDAO.getTodoList("001")).andReturn(todoList);
        
        expect(userManager.getCurrentUser()).andReturn(user);
        
        replay_();
        try {
            TodoList testTodoList = todoListsManager.findTodoList("001");
            assertEquals(todoList, testTodoList);
        } catch (PermissionDeniedException pde) {
            fail("Permission denied when looking for Todo.");
        }
    }
    
    public void testFailedFindTodoList() {
        expect(todoListDAO.getTodoList("001")).andReturn(todoList);
        
        expect(userManager.getCurrentUser()).andReturn(user);
        
        replay_();
        
        try {
            todoListsManager.findTodoList("001");
            fail("A PermissionDeniedException should have been thrown");
        } catch (PermissionDeniedException pde) {
            
        }
    }
    
    public void testUpdateTodoList() {
        todoListDAO.updateTodoList(todoList);
        
        replay_();
        
        todoListsManager.updateTodoList(todoList);
    }
    
    public void testDeleteTodoList() {
        user.getTodoLists().add(todoList);
        
        expect(userManager.getCurrentUser()).andReturn(user);
        
        expect(userManager.getCurrentUser()).andReturn(user);
        
        expect(todoListDAO.getTodoList("001")).andReturn(todoList);
        
        userManager.updateUser(user);

        todoListDAO.removeTodoList("001");

        replay_();
        
        todoListsManager.deleteTodoList("001");
        
        assertFalse(user.getTodoLists().contains(todoList));
    }
    
    public void testAddTodoListUser() {
        todoList.getUsers().add(user);
        user.getTodoLists().add(todoList);
        
        expect(userManager.getCurrentUser()).andReturn(user);
        
        expect(todoListDAO.getTodoList("001")).andReturn(todoList);
        
        User user2 = new User();
        user2.setLogin("another_user");
        expect(userManager.findUser("another_user")).andReturn(user2);
        
        replay_();
        
        todoListsManager.addTodoListUser("001", "another_user");
        
        assertTrue(todoList.getUsers().contains(user2));
        assertTrue(user2.getTodoLists().contains(todoList));
    }
    
    public void testDeleteTodoListUser() {
        todoList.getUsers().add(user);
        user.getTodoLists().add(todoList);
        
        User user2 = new User();
        user2.setLogin("another_user");
        user2.getTodoLists().add(todoList);
        todoList.getUsers().add(user2);
        
        expect(userManager.getCurrentUser()).andReturn(user);
        
        expect(todoListDAO.getTodoList("001")).andReturn(todoList);
        
        expect(userManager.findUser("another_user")).andReturn(user2);
        
        replay_();
        
        todoListsManager.deleteTodoListUser("001", "another_user");
        
        assertFalse(todoList.getUsers().contains(user2));
        assertFalse(user2.getTodoLists().contains(todoList));
    }
    
    public void testBackupTodoList() {
        todoList.getUsers().add(user);
        
        Todo todo = new Todo();
        todo.setTodoId("0001");
        Calendar creationCal = Calendar.getInstance();
        creationCal.clear();
        creationCal.set(Calendar.YEAR, 2005);
        todo.setCreationDate(creationCal.getTime());
        todo.setDescription("Backup Test description");
        todo.setPriority(0);
        todo.setCompleted(false);
        
        todoList.getTodos().add(todo);
        
        replay_();
        
        Document doc = todoListsManager.backupTodoList(todoList);
        
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        String xmlContent = outputter.outputString(doc);

        assertTrue(xmlContent.indexOf("<title>Test Todo List</title>") > 0);
        assertTrue(xmlContent.indexOf("<todo id=\"0001\">") > 0);
        assertTrue(xmlContent.indexOf("<creationDate>" + creationCal.getTimeInMillis() + "</creationDate>") > 0);
        assertTrue(xmlContent.indexOf("<description>Backup Test description</description>") > 0);
        assertTrue(xmlContent.indexOf("<priority>0</priority>") > 0);
        assertTrue(xmlContent.indexOf("<completed>false</completed>") > 0);
    }
    
    public void testRestoreTodoListCreate() throws Exception {
        InputStream content = new ByteArrayInputStream(todoListBackup.getBytes());

        expect(userManager.getCurrentUser()).andReturn(user);
        TodoList todoList = new TodoList();
        todoListDAO.saveTodoList(todoList);
        userManager.updateUser(user);
        Todo todo = new Todo();
        todoDAO.saveTodo(todo);
        
        replay_();
        
        todoListsManager.restoreTodoList("create", "001", content);
    }

    public void testRestoreTodoListReplace() throws Exception {
        InputStream content = new ByteArrayInputStream(todoListBackup.getBytes());
        
        todoList.getUsers().add(user);
        user.getTodoLists().add(todoList);
        
        Todo todo = new Todo();
        todo.setTodoId("0001");
        todo.setTodoList(todoList);
        todoList.getTodos().add(todo);
        
        expect(todoListDAO.getTodoList("001")).andReturn(todoList);
        expect(userManager.getCurrentUser()).andReturn(user);
        todoDAO.removeTodo("0001");
        todoListDAO.updateTodoList(todoList);
        Todo createdTodo = new Todo();
        todoDAO.saveTodo(createdTodo);
        
        replay_();
        
        todoListsManager.restoreTodoList("replace", "001", content);
    }
    
    public void testRestoreTodoListMerge() throws Exception {
        InputStream content = new ByteArrayInputStream(todoListBackup.getBytes());

        todoList.getUsers().add(user);
        user.getTodoLists().add(todoList);
        
        expect(todoListDAO.getTodoList("001")).andReturn(todoList);
        expect(userManager.getCurrentUser()).andReturn(user);
        
        Todo createdTodo = new Todo();
        todoDAO.saveTodo(createdTodo);
        
        todoListDAO.updateTodoList(todoList);
        
        replay_();
        
        todoListsManager.restoreTodoList("merge", "001", content);
        
        assertNotNull(todoList.getLastUpdate());
    }
}
