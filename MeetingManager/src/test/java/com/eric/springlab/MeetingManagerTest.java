package com.eric.springlab;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/6/12
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MeetingManagerTest  {
    private MeetingManager manager = new MeetingManager();

    @Before
    public void setup() {
//        manager = new MeetingManager();
    }

    @Test
    public void testAddMeetingPlace() throws Exception {

    }

    @Test
    public void testReserveMeeting() throws Exception {

    }

    @Test
    public void testCancelMeeting() throws Exception {
        manager.cancelMeeting(new Meeting());

    }

    @Test
    public void testGenerateId() throws Exception {
        String id1 = manager.generateId();
        assertEquals(id1, manager.generateId());
    }
}
