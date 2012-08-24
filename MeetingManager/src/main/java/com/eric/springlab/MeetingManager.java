package com.eric.springlab;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/6/12
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class MeetingManager {
    private List<MeetingPlace> places = new ArrayList<MeetingPlace>();
    private List<Meeting> reservations = new ArrayList<Meeting>();
    private static int sequence;

    public void addMeetingPlace(MeetingPlace place) {
        places.add(place);
    }

    public Meeting reserveMeeting(MeetingFacilityConfiguration requirement) {
        return null;
    }

    public void cancelMeeting(Meeting meeting) {
        reservations.remove(meeting);
    }

    public String generateId() {
        String format = String.format("%%0%dd", 5);
        System.out.println(String.format(format, sequence++));
        return String.format(format, sequence++);
//        DecimalFormat nf = new DecimalFormat("000000");
//        return nf.format(sequence++);
    }
}
