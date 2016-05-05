package com.service;

import java.sql.SQLException;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.dao.UserDao;
import com.domain.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	@Override
	public User userInfo(String userNum){
		
		try {
			System.out.println("userService id : ----------------------------------------"+userNum+"--------------------------------------");
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
