package com.service;

import org.springframework.ui.Model;

import com.dao.UserDao;
import com.domain.User;

public class AppServiceImpl implements AppService {
	
	UserDao userDao;
	
	@Override
	public String userInfo(Long userNum){
		
		return userDao.getUserInfo(userNum);
	}
	
	@Override
	public String catchUser(Long userNum, Long locate){
		return userDao.setCatchUser(userNum, locate);
	}
	
	@Override
	public String signUp(User user){
		return userDao.setSignUp(user);
	}
}
