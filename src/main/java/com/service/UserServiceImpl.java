package com.service;

import java.sql.SQLException;

import org.springframework.ui.Model;

import com.dao.UserDao;
import com.domain.User;

public class UserServiceImpl implements UserService {
	
	UserDao userDao;

	@Override
	public User userInfo(String userNum){
		
		try {
			return userDao.getUserInfo(userNum);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public String signUp(User user){
		return userDao.add(user);
	}
}
