package net.twasink.hsqldbtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@Transactional
public class FooTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void shouldHaveAnEntityManager() {
        assertNotNull(entityManager);
    }

    @Test
    public void shouldHaveNoObjectsAtStart() {
        List<?> results = entityManager.createQuery("from Foo").getResultList();
        assertTrue(results.isEmpty());
    }

    @Test
    public void shouldBeAbleToPersistAnObject() {
        assertEquals(0, entityManager.createQuery("from Foo").getResultList().size());
        Foo jobUser = new Foo("Bar");
        entityManager.persist(jobUser);
        entityManager.flush();
        assertEquals(1, entityManager.createQuery("from Foo").getResultList().size());
    }

    @Test
    public void shouldBeABleToQueryForObjects() {
        shouldBeAbleToPersistAnObject();

        assertEquals(1, entityManager.createQuery("from Foo where name = 'Bar'").getResultList().size());
        assertEquals(0, entityManager.createQuery("from Foo where name = 'Baz'").getResultList().size());
    }
}