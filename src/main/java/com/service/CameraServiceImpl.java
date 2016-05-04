package com.service;

import java.sql.SQLException;

import com.dao.CameraDao;
import com.domain.Camera;

public class CameraServiceImpl implements CameraService {
	private CameraDao cameraDao;
	
	public void setCameraDao(CameraDao cameraDao){
		this.cameraDao = cameraDao;
	}
	
	@Override
	public String startCamera(Long userId, int beaconid) {
		try {
			Camera camera = cameraDao.get(beaconid);
			return camera.getDomain();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void savePhoto(Long userId, String photoPath) {
		// TODO Auto-generated method stub
		
	}

}
