package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.domain.User;

public class UserDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource){ 
		this.dataSource = dataSource;
	}

	public User getUserInfo(String id) throws ClassNotFoundException, SQLException {
		System.out.println("userDao id : ----------------------------------------"+id+"--------------------------------------");
		Connection connection = dataSource.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
        preparedStatement.setString(1, id);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        
        User user = new User();
        
        user.setId(resultSet.getString("id"));
        
        resultSet.close();
        preparedStatement.close();
        connection.close();
        
		return user;
	}

	public String add(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

}
