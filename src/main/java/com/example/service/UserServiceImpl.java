package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User userInfo(String id) throws ClassNotFoundException, SQLException {
		return userRepository.findOne(id);
	}

	@Override
	public User add(String id) throws SQLException {
		return null;
	}
}
