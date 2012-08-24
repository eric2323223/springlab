package tudu.domain.dao.hibernate3;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;

import javax.naming.NamingException;
import javax.naming.spi.NamingManager;
import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

/**
 * Launches an in-memory HSQLDB database.
 * 
 * @author Julien Dubois
 */
public class HsqldbLauncher {

    private static SimpleNamingContextBuilder builder;

    private static DataSource dataSource;

    public static void launch() {
        if (builder == null) {
            if (!NamingManager.hasInitialContextFactoryBuilder()) {
                System.out.println("Launching the database.");
                SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
                dataSource = new DriverManagerDataSource(
                        "org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:tudu", "sa",
                        "");
                builder.bind("java:comp/env/jdbc/tudu", dataSource);
                try {
                    builder.activate();
                } catch (NamingException e) {
                    throw new RuntimeException(
                            "Problème dans l'activation JNDI");
                }
                System.out.println("Creating the database schema.");
                Connection jdbcConnection;
                try {
                    jdbcConnection = dataSource.getConnection();
                    Statement stmt = jdbcConnection.createStatement();
    
                    stmt.execute("CREATE MEMORY TABLE PROPERTY(PKEY VARCHAR(100) NOT NULL PRIMARY KEY,VALUE VARCHAR(200))");
                    stmt.execute("CREATE MEMORY TABLE ROLE(ROLE VARCHAR(50) NOT NULL PRIMARY KEY)");
                    stmt.execute("CREATE MEMORY TABLE TODO(ID VARCHAR(32) NOT NULL PRIMARY KEY,CREATION_DATE TIMESTAMP NOT NULL,DESCRIPTION VARCHAR(255) NOT NULL,PRIORITY INTEGER NOT NULL,COMPLETED TINYINT NOT NULL,COMPLETION_DATE TIMESTAMP,TODO_LIST_ID VARCHAR(32) NOT NULL,DUE_DATE TIMESTAMP)");
                    stmt.execute("CREATE MEMORY TABLE TODO_LIST(ID VARCHAR(32) NOT NULL PRIMARY KEY,NAME VARCHAR(100) NOT NULL,RSS_ALLOWED TINYINT NOT NULL,LAST_UPDATE TIMESTAMP)");
                    stmt.execute("CREATE MEMORY TABLE USER(LOGIN VARCHAR(50) NOT NULL PRIMARY KEY,PASSWORD VARCHAR(50) NOT NULL,ENABLED TINYINT NOT NULL,FIRST_NAME VARCHAR(100),LAST_NAME VARCHAR(100),EMAIL VARCHAR(150),CREATION_DATE TIMESTAMP NOT NULL,LAST_ACCESS_DATE TIMESTAMP NOT NULL)");
                    stmt.execute("CREATE MEMORY TABLE USER_ROLE(LOGIN VARCHAR(50) NOT NULL,ROLE VARCHAR(50) NOT NULL,CONSTRAINT SYS_FK_51 FOREIGN KEY(LOGIN) REFERENCES USER(LOGIN),CONSTRAINT SYS_FK_52 FOREIGN KEY(ROLE) REFERENCES ROLE(ROLE))");
                    stmt.execute("CREATE MEMORY TABLE USER_TODO_LIST(LOGIN VARCHAR(50) NOT NULL,LISTID VARCHAR(32) NOT NULL,CONSTRAINT SYS_FK_58 FOREIGN KEY(LOGIN) REFERENCES USER(LOGIN),CONSTRAINT SYS_FK_59 FOREIGN KEY(LISTID) REFERENCES TODO_LIST(ID))");
    
                    jdbcConnection.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        }
    }

    public static void populateDatabase() {
        Connection jdbcConnection;
        try {
            jdbcConnection = dataSource.getConnection();

            System.out.println("Populating the database.");
            IDatabaseConnection connection = new DatabaseConnection(
                    jdbcConnection);

            InputStream dataset = HsqldbLauncher.class.getClassLoader()
                    .getResourceAsStream("database_dump_simple.xml");

            IDataSet dataSet = new FlatXmlDataSet(dataset);
            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
