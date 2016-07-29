package com.example.camera.application;

import com.example.camera.domain.Camera;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public interface CameraService {
	/*	서버 <-> 카메라 서비스
	 * 1. 서버->카메라 실행, 유저아이디
	 * 2. 사진이 찍힌후, 카메라에서 오는 유저아이디와 경로 저장
	 */
	
	public Camera startCamera(String userId, String beaconid) throws IOException, ClassNotFoundException, SQLException;
	public void savePhoto(Long userId, String photoPath);
	public Camera setCameraDomain(HttpServletRequest request) throws SQLException, ClassNotFoundException;
}
