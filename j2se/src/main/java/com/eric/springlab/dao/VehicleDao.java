package com.eric.springlab.dao;

import com.eric.springlab.model.Vehicle;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/30/12
 * Time: 9:55 AM
 * To change this template use File | Settings | File Templates.
 */
public interface VehicleDao {
    public void insert(Vehicle vehicle);
    public void update(Vehicle vehicle);
    public void delete(Vehicle vehicle);
    public Vehicle findByVehicleNo(String vehicleNo);
}
