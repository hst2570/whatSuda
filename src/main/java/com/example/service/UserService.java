package com.example.service;

import com.example.model.User;

import java.sql.SQLException;

public interface UserService {
	/*	앱 <->서버 서비스
	 * 1. 유저정보 나열 >> findAll
	 * 2. 최단경로 나열
	 * 3. 회원가입
	 * 4. 사진 촬영 이벤트
	 */
	
	public User userInfo(String id) throws ClassNotFoundException, SQLException;
	
//	public void photoEvent(String beaconNum);
	
	public User add(String id) throws SQLException;

	
}
