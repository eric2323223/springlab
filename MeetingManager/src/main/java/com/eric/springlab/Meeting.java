package com.eric.springlab;

import org.joda.time.DateTime;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/6/12
 * Time: 10:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class Meeting {
    String name;
    MeetingPlace place;
    final String id;
    DateTime start;
    DateTime end;
    Employee host;
    List<Employee> attendee;

    public Meeting(List<Employee> attendee, Employee host, DateTime start, DateTime end, String name, MeetingManager meetingManager) {
        this.attendee = attendee;
        this.host = host;
        this.start = start;
        this.end = end;
        this.name = name;
        this.id = meetingManager.generateId();
    }


}
