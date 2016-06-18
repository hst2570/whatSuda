package com.example.service;

import com.example.model.Camera;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

@Service("CameraService")
public class CameraServiceImpl implements CameraService {

	@Override
	public Camera startCamera(int userId, int beaconid) throws IOException, ClassNotFoundException, SQLException {
		return null;
	}

	@Override
	public void savePhoto(Long userId, String photoPath) {

	}

	@Override
	public Camera setCameraDomain(String domain, int cameraId, int beaconId) throws SQLException, ClassNotFoundException {
		return null;
	}
}
