package com.eric.mvnlab.dao.impl;

import com.eric.mvnlab.dao.VehicleDao;
import com.eric.mvnlab.model.Vehicle;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/30/12
 * Time: 9:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class JdbcVehicelDao extends SimpleJdbcDaoSupport implements VehicleDao {
//    private JdbcTemplate jdbcTemplate;
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public void insert(final Vehicle vehicle) {
        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
                + "VALUES (?, ?, ?, ?)";
        getSimpleJdbcTemplate().update(sql, new Object[]{vehicle.getVehicleNo(),
                vehicle.getColor(), vehicle.getWheel(), vehicle.getSeat()});
    }

    public String getColor(String vehicleNo) {
        String sql = "SELECT COLOR FROM VEHICLE WHERE VEHICLE_NO = ?";
// No need to cast into String anymore.
        String color = getSimpleJdbcTemplate().queryForObject(sql,
                String.class, vehicleNo);
        return color;
    }

    public List<Vehicle> findAll() {
        String sql = "SELECT * FROM VEHICLE";
        List<Vehicle> vehicles = getSimpleJdbcTemplate().query(sql,
                ParameterizedBeanPropertyRowMapper.newInstance(Vehicle.class));
        return vehicles;
    }

    @Override
    public void update(Vehicle vehicle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Vehicle vehicle) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Vehicle findByVehicleNo(String vehicleNo) {
        String sql = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
// No need to cast into Vehicle anymore.
        Vehicle vehicle = getSimpleJdbcTemplate().queryForObject(sql,
                ParameterizedBeanPropertyRowMapper.newInstance(Vehicle.class),
                vehicleNo);
        return vehicle;
    }

}
