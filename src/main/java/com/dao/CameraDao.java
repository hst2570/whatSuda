package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.domain.Camera;

public class CameraDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource){ 
		this.dataSource = dataSource;
	}

	public Camera get(int id) throws ClassNotFoundException, SQLException {
			
		Connection connection = dataSource.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("select * from camera where beaconid = ?");
        preparedStatement.setInt(1, id);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        
        Camera camera = new Camera();
        
        camera.setDomain(resultSet.getString("domain"));
        camera.setBeaconid(resultSet.getInt("beaconid"));
        camera.setCameraid(resultSet.getInt("cameraid"));
        
        resultSet.close();
        preparedStatement.close();
        connection.close();
        
		return camera;
	}

	public Camera setCamera(String domain, int cameraId, int beaconId) throws SQLException {
		Connection connection = dataSource.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("insert into camera(domain, cameraid, beaconid) values"
				+ "?, ?, ?");
        preparedStatement.setString(1, domain);
        preparedStatement.setInt(1, cameraId);
        preparedStatement.setInt(1, beaconId);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        
        Camera camera = new Camera();
        
        camera.setDomain(resultSet.getString("domain"));
        camera.setBeaconid(resultSet.getInt("beaconid"));
        camera.setCameraid(resultSet.getInt("cameraid"));
        
        resultSet.close();
        preparedStatement.close();
        connection.close();
        
        return camera;
	}
}
