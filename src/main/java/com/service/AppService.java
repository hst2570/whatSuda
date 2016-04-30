package com.service;

import org.springframework.ui.Model;

import com.dao.UserDao;
import com.domain.User;

public interface AppService {
	/*	앱 <->서버 서비스
	 * 1. 유저정보 나열 >> findAll
	 * 2. 최단경로 나열
	 * 3. 회원가입
	 * 4. 사진 촬영 이벤트
	 */
	
	public String userInfo(Long userNum);
	
	public String catchUser(Long userNum, Long locate);
	
	public String signUp(User user);

	
}
