package tudu.service.impl;

import junit.framework.TestCase;

import static org.easymock.EasyMock.*;

import tudu.domain.dao.TodoDAO;
import tudu.domain.model.Todo;
import tudu.domain.model.TodoList;
import tudu.domain.model.User;
import tudu.security.PermissionDeniedException;
import tudu.service.TodoListsManager;
import tudu.service.UserManager;

public class TodosManagerImplTest extends TestCase {

    Todo todo = new Todo();
    TodoList todoList = new TodoList();
    User user = new User();
    
    TodoDAO todoDAO = null;
    TodoListsManager todoListsManager = null;
    UserManager userManager = null;
    
    TodosManagerImpl todosManager = new TodosManagerImpl();
    
    public void setUp() {
        todo.setTodoId("0001");
        todo.setDescription("Test description");
        todo.setPriority(0);
        todo.setCompleted(false);
        
        todoList.setListId("001");
        todoList.setName("Test Todo List");
        todoList.setRssAllowed(false);
        
        user.setLogin("test_user");
        user.setFirstName("First name");
        user.setLastName("Last name");
        
        todoDAO = (TodoDAO) createMock(TodoDAO.class);
        todoListsManager = (TodoListsManager) createMock(TodoListsManager.class);
        userManager = (UserManager)createMock(UserManager.class);
        
        todosManager.setTodoDAO(todoDAO);
        todosManager.setTodoListsManager(todoListsManager);
        todosManager.setUserManager(userManager);
    }
    
    public void tearDown() {
    	verify(todoDAO);
        verify(todoListsManager);
        verify(userManager);
    }
    
    private void replay_() {
        replay(todoDAO);
        replay(todoListsManager);
        replay(userManager);
    }
    
    public void testFindTodo() {
        todo.setTodoList(todoList);
        expect(todoDAO.getTodo("0001")).andReturn(todo);
        
        user.getTodoLists().add(todoList);
        expect(userManager.getCurrentUser()).andReturn(user);
        
        replay_();
        
        try {
            Todo testTodo = todosManager.findTodo("0001");
            assertEquals(todo, testTodo);
        } catch (PermissionDeniedException pde) {
            fail("Permission denied when looking for Todo.");
        }
    }
    
    public void testFailedFindTodo() {
        expect(todoDAO.getTodo("0001")).andReturn(todo);
        
        expect(userManager.getCurrentUser()).andReturn(user);
        
        replay_();
        
        try {
            todosManager.findTodo("0001");
            fail("A PermissionDeniedException should have been thrown");
        } catch (PermissionDeniedException pde) {

        }
    }
    
    public void testCreateTodo() {
        expect(todoListsManager.findTodoList("001")).andReturn(todoList);
        
        todoDAO.saveTodo(todo);
        
        todoListsManager.updateTodoList(todoList);
        
        replay_();
        
        todosManager.createTodo("001", todo);
        
        assertNotNull(todo.getCreationDate());
        assertEquals(todoList, todo.getTodoList());
        assertTrue(todoList.getTodos().contains(todo));
    }
    
    public void testUpdateTodo() {
        todoDAO.saveTodo(todo);
        todoListsManager.updateTodoList(todo.getTodoList());
        
        replay_();
        
        todo.setCompleted(true);
        todosManager.updateTodo(todo);
        assertTrue(todo.isCompleted());
    }
    
    public void testDeleteTodo() {
        todo.setTodoList(todoList);
        todoList.getTodos().add(todo);
        expect(todoDAO.getTodo("0001")).andReturn(todo);
        
        user.getTodoLists().add(todoList);
        expect(userManager.getCurrentUser()).andReturn(user);
        
        todoDAO.removeTodo("0001");
        todoListsManager.updateTodoList(todo.getTodoList());
        
        replay_();
        
        todosManager.deleteTodo("0001");
        
        assertFalse(todoList.getTodos().contains(todo));
    }
    
    public void testCompleteTodo() {
        todo.setTodoList(todoList);
        todoList.getTodos().add(todo);
        expect(todoDAO.getTodo("0001")).andReturn(todo);
        
        user.getTodoLists().add(todoList);
        expect(userManager.getCurrentUser()).andReturn(user);
        
        todoListsManager.updateTodoList(todo.getTodoList());
        
        replay_();
        
        Todo todo = todosManager.completeTodo("0001");
        
        assertTrue(todo.isCompleted());
        assertNotNull(todo.getCompletionDate());
    }
    
    public void testReopenTodo() {
        todo.setTodoList(todoList);
        todoList.getTodos().add(todo);
        expect(todoDAO.getTodo("0001")).andReturn(todo);
        
        user.getTodoLists().add(todoList);
        expect(userManager.getCurrentUser()).andReturn(user);
        
        todoListsManager.updateTodoList(todo.getTodoList());
        
        replay_();
        
        Todo todo = todosManager.reopenTodo("0001");
        
        assertFalse(todo.isCompleted());
        assertNull(todo.getCompletionDate());
    }
}
