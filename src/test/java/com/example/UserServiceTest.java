package com.example;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.User;
import com.example.service.UserService;

public class UserServiceTest {
private UserService userService;
	@Before
    public void setup(){
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("daoFactory.xml");
        userService = (UserService) applicationContext.getBean("userService");
    }
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
//	@RequestMapping("/user/info/{id}")
	@Test
    public void userInfo() throws ClassNotFoundException, SQLException  {
		String id = "1";
		User user = userService.userInfo(id);
		assertEquals(id, user.getId()); 
    }
}
