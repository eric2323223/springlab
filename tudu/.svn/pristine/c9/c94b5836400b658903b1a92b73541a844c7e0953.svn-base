package tudu.web;

import java.io.File;

import servletunit.struts.MockStrutsTestCase;
import tudu.domain.dao.hibernate3.HsqldbLauncher;

/**
 * Base object for testing Struts actions with Strutstestcase.
 * 
 * @author Julien Dubois
 */
public class TuduBaseMockStrutsTestCase extends MockStrutsTestCase {

    protected void setUp() throws Exception {
        super.setUp();
        HsqldbLauncher.launch();
        HsqldbLauncher.populateDatabase();
        
        System.out.println("Launching Struts");
        String webappDir = System.getProperty("TUDU_WEBAPP_DIR");
        if (webappDir == null) {
            webappDir = "src/webapp";
        }
        File webXml = new File(webappDir + "/WEB-INF/web.xml");
        if (!webXml.exists()) {
            fail("web.xml not found.");
        }
        File context = new File(webappDir);
        if (!context.exists()) {
            fail("context directory not found.");
        }
        File strutsXml = new File(webappDir + "/WEB-INF/struts-config.xml");
        if (!strutsXml.exists()) {
            fail("struts-config.xml not found.");
        }
        this.setServletConfigFile(webXml.getAbsolutePath());
        this.setConfigFile(strutsXml.getAbsolutePath());
        this.setContextDirectory(context);
    }
}
