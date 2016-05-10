package com.example.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.domain.User;

@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	@Override
	public User userInfo(String id) throws SQLException{
		User user = userDao.getUserInfo(id); 
		return user;
	}
	
	@Override
	public User add(String id) throws SQLException{
		User user = new User();
		user.setId(id);
		return userDao.add(user);
	}
}
