package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

import com.example.dao.CameraDao;
import com.example.domain.Camera;

public class CameraServiceImpl implements CameraService {
	private CameraDao cameraDao;
	
	public void setCameraDao(CameraDao cameraDao){
		this.cameraDao = cameraDao;
	}
	
	@Override
	public Camera startCamera(int userid, int beaconid) throws IOException, ClassNotFoundException, SQLException {
		Camera camera = cameraDao.get(beaconid);
		
        URL url = new URL(camera.getDomain()+"?userid="+userid);
        System.out.println(url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        
        if(con.getResponseCode() == 404){
        	camera.setDomain(null);
        	camera.setBeaconid(0);
        	camera.setCameraid(0);
        	return camera;
        }
       
        return camera;
	}

	@Override
	public void savePhoto(Long userId, String photoPath) {
		// TODO Auto-generated method stub
		
	}
	
	//임시 도메인 셋팅메소드
	public Camera setCameraDomain(String domain, int cameraId, int beaconId) throws SQLException, ClassNotFoundException{
		return cameraDao.setCamera(domain, cameraId, beaconId);
	}

}
