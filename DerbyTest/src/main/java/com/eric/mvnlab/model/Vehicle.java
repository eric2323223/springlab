package com.eric.mvnlab.model;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/31/12
 * Time: 9:44 AM
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

    public Vehicle(){}

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }

    public void setSeat(int seat) {
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
