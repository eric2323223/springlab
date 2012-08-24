package tudu.testsuite;

import junit.framework.Test;
import junit.framework.TestSuite;
import tudu.domain.dao.hibernate3.UserDAOHibernateTest;
import tudu.domain.model.TodoTest;
import tudu.domain.model.comparator.TodoByDescriptionAscComparatorTest;
import tudu.domain.model.comparator.TodoByDescriptionComparatorTest;
import tudu.domain.model.comparator.TodoByDueDateAscComparatorTest;
import tudu.domain.model.comparator.TodoByDueDateComparatorTest;
import tudu.domain.model.comparator.TodoByPriorityAscComparatorTest;
import tudu.security.UserDetailsServiceImplTest;
import tudu.service.impl.ConfigurationManagerImplTest;
import tudu.service.impl.TodoListsManagerImplTest;
import tudu.service.impl.TodosManagerImplTest;
import tudu.service.impl.UserManagerImplTest;
import tudu.web.MyInfoActionTest;
import tudu.web.ShowTodoListsActionTest;
import tudu.web.ShowTodosActionTest;
import tudu.web.dwr.impl.TodoListsDwrImplTest;
import tudu.web.dwr.impl.TodosDwrImplTest;
import tudu.web.servlet.BackupServletTest;
import tudu.web.servlet.RssFeedServletTest;

public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("Tests for tudu.*");
        suite.addTestSuite(UserDAOHibernateTest.class);
        suite.addTestSuite(TodoTest.class);
        suite.addTestSuite(TodoByDescriptionComparatorTest.class);
        suite.addTestSuite(TodoByDescriptionAscComparatorTest.class);
        suite.addTestSuite(TodoByDueDateComparatorTest.class);
        suite.addTestSuite(TodoByDueDateAscComparatorTest.class);
        suite.addTestSuite(TodoByPriorityAscComparatorTest.class);
        suite.addTestSuite(UserDetailsServiceImplTest.class);
        suite.addTestSuite(ConfigurationManagerImplTest.class);
        suite.addTestSuite(TodoListsManagerImplTest.class);
        suite.addTestSuite(TodosManagerImplTest.class);
        suite.addTestSuite(UserManagerImplTest.class);
        suite.addTestSuite(MyInfoActionTest.class);
        suite.addTestSuite(ShowTodoListsActionTest.class);
        suite.addTestSuite(ShowTodosActionTest.class);
        suite.addTestSuite(TodoListsDwrImplTest.class);
        suite.addTestSuite(TodosDwrImplTest.class);
        suite.addTestSuite(BackupServletTest.class);
        suite.addTestSuite(RssFeedServletTest.class);
        return suite;
    }

}
