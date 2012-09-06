package com.eric.springlab.server.dao.impl;

import javax.annotation.Resource;

import org.junit.Test;

import com.eric.springlab.ApplicationContextAwareTest;
import com.eric.springlab.server.dao.DummyDAO;
import com.eric.springlab.server.entity.DummyEntity;

import static org.junit.Assert.assertEquals;

/**
 * 
 */
public class SimpleIntegrationTest extends ApplicationContextAwareTest {

    @Resource
    private DummyDAO dummyDAO;

    /**
     * Tries to store {@link com.eric.springlab.server.entity.DummyEntity}.
     */
    @Test
    public void testPersistTestEntity() {
        int countBefore = dummyDAO.findAll().size();
        DummyEntity dummyEntity = new DummyEntity();
        dummyDAO.makePersistent(dummyEntity);

        int countAfter = dummyDAO.findAll().size();
        assertEquals(countBefore + 1, countAfter);
    }
}
