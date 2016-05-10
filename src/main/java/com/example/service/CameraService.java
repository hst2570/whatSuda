package com.example.service;

import java.io.IOException;
import java.sql.SQLException;

import com.example.domain.Camera;

public interface CameraService {
	/*	서버 <-> 카메라 서비스
	 * 1. 서버->카메라 실행, 유저아이디
	 * 2. 사진이 찍힌후, 카메라에서 오는 유저아이디와 경로 저장
	 */
	
	public Camera startCamera(int userId, int beaconid) throws IOException, ClassNotFoundException, SQLException;
	public void savePhoto(Long userId, String photoPath);
	public Camera setCameraDomain(String domain, int cameraId, int beaconId) throws SQLException, ClassNotFoundException;
}