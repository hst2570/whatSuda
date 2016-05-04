package com.service;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;

import com.dao.CameraDao;
import com.domain.Camera;

public class CameraServiceImpl implements CameraService {
	private CameraDao cameraDao;
	
	public void setCameraDao(CameraDao cameraDao){
		this.cameraDao = cameraDao;
	}
	
	@Override
	public void startCamera(Long userId, int beaconid) {
		try {
			Camera camera = cameraDao.get(beaconid);
						
			String encoded = null;
	        DataOutputStream  out = null;
	        try{
	            URL url = new URL(camera.getDomain()+"?userid="+userId);
	            URLConnection conn = url.openConnection();
	            HttpURLConnection hurlc = (HttpURLConnection) conn;
	            // 헤더값을 설정한다.
//	            hurlc.setRequestProperty(키, 값);
//	            hurlc.setRequestMethod("get");
	            hurlc.setDoOutput(true);
	            hurlc.setDoInput(true);
	            hurlc.setUseCaches(false);
	            hurlc.setDefaultUseCaches(false);
//	            encoded = ;
	            out = new DataOutputStream(conn.getOutputStream());
//	            out.writeBytes(encoded);
	            out.flush();
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            try{
	                out.close();
	            }catch(Exception e){}
	        }
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void savePhoto(Long userId, String photoPath) {
		// TODO Auto-generated method stub
		
	}
	
	public void setCameraDomain(String domain, int cameraId, int beaconId) throws SQLException{
		cameraDao.setCamera(domain, cameraId, beaconId);
	}

}
