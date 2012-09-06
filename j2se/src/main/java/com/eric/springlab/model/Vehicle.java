package com.eric.springlab.model;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/30/12
 * Time: 9:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Vehicle {
    private String vehicleNo;
    private String color;
    private int wheel;
    private int seat;

    public Vehicle(String vehicle_no, String color, int wheel, int seat) {
        this.vehicleNo = vehicle_no;
        this.color = color;
        this.wheel = wheel;
        this.seat = seat;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getColor() {
        return color;
    }

    public int getWheel() {
        return wheel;
    }

    public int getSeat() {
        return seat;
    }
}
