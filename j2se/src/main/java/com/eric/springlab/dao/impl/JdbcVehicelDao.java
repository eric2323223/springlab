package com.eric.springlab.dao.impl;

import com.eric.springlab.dao.VehicleDao;
import com.eric.springlab.model.Vehicle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/30/12
 * Time: 9:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class JdbcVehicelDao implements VehicleDao {
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void insert(Vehicle vehicle) {
        String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
                + "VALUES (?, ?, ?, ?)";
        Connection conn = null;try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vehicle.getVehicleNo());
            ps.setString(2, vehicle.getColor());
            ps.setInt(3, vehicle.getWheel());
            ps.setInt(4, vehicle.getSeat());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
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
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vehicleNo);
            Vehicle vehicle = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vehicle = new Vehicle(rs.getString("VEHICLE_NO"),
                        rs.getString("COLOR"), rs.getInt("WHEEL"),
                        rs.getInt("SEAT"));
            }
            rs.close();
            ps.close();
            return vehicle;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
