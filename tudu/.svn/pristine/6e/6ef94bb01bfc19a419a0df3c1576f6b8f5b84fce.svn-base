package tudu.service.impl;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import junit.framework.TestCase;
import tudu.domain.dao.PropertyDAO;
import tudu.domain.model.Property;

public class ConfigurationManagerImplECTest extends TestCase {

    private PropertyDAO propertyDAO = null;

    private ConfigurationManagerImpl configurationManager = null;

    protected void setUp() throws Exception {
        // Création du simulacre
        propertyDAO = createMock(PropertyDAO.class);

        // Création du manager
        configurationManager = new ConfigurationManagerImpl();
        configurationManager.setPropertyDAO(propertyDAO);
    }

    public void testGetProperty() {
        Property property = new Property();
        property.setKey("key");
        property.setValue("value");
        expect(propertyDAO.getProperty("key")).andReturn(property).times(2);
        Property defaultProperty = new Property();
        defaultProperty.setKey("default");
        defaultProperty.setValue("default");
        expect(propertyDAO.getProperty((String) anyObject())).andStubReturn(
                defaultProperty);

        replay(propertyDAO);
        Property test = configurationManager.getProperty("anything");
        assertEquals("default", test.getValue());
        test = configurationManager.getProperty("key");
        assertEquals("value", test.getValue());
        test = configurationManager.getProperty("key");
        assertEquals("value", test.getValue());

        verify(propertyDAO);
    }

}
