package tudu.domain.model;

import junit.framework.TestCase;

public class TodoECTest extends TestCase {
    private Todo todo1;

    private Todo todo2;

    private Todo todo3;
    
    public TodoECTest(String name) {
        super(name);
     }

    protected void setUp() throws Exception {
        todo1 = new Todo();
        todo1.setTodoId("01");
        todo1.setCompleted(false);
        todo1.setDescription("Description");
        todo1.setPriority(0);

        todo2 = new Todo();
        todo2.setTodoId("02");
        todo2.setCompleted(true);
        todo2.setDescription("Description");
        todo2.setPriority(0);

        todo3 = new Todo();
        todo3.setTodoId("01");
        todo3.setCompleted(false);
        todo3.setDescription("Description");
        todo3.setPriority(0);
    }

    public void testCompareTo() {
        // Vérifie la consistance avec la mthode equals
        assertTrue(todo1.compareTo(todo1) == 0);

        // Vérifie le respect de la spec de Comparable
        // Cf. JavaDoc de l'API J2SE
        try {
            todo1.compareTo(null);
            fail();
        } catch (NullPointerException e) {
        }

        // todo1 n'est pas fermé donc < ‡ todo2
        assertTrue(todo1.compareTo(todo2) < 0);

        // Vérifie que l'inverse est vrai aussi
        assertTrue(todo2.compareTo(todo1) > 0);
    }

    public void testEquals() {
        assertEquals(todo1, todo3);
        assertFalse(todo1.equals(todo2));
    }
}
