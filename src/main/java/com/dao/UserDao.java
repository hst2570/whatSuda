package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.domain.User;

public class UserDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource){ 
		this.dataSource = dataSource;
	}

	public User getUserInfo(String id) throws SQLException {
		int ids = Integer.parseInt(id);
		System.out.println("userDao id : ----------------------------------------"+id+"--------------------------------------");
		Connection connection;
		User user = new User();
		connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
        preparedStatement.setInt(1, ids);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        
        
        
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
