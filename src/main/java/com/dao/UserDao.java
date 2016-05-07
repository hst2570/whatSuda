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

	public User add(User user) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(?)");
        preparedStatement.setString(1, user.getId());
        
        preparedStatement.executeUpdate();
        
        PreparedStatement preparedStatement2 = connection.prepareStatement("select last_insert_id()");

        ResultSet resultSet = preparedStatement2.executeQuery();
        resultSet.next();

        resultSet.close();
        preparedStatement2.close();
        preparedStatement.close();
        connection.close();
        
        return getUserInfo(user.getId());
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

}
