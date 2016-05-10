package com.example.controller;

import java.sql.SQLException;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.User;
import com.example.service.UserService;

@ContextConfiguration("classpath:/daoFactory.xml")
@Controller
public class UserCommuController {
	private UserService userService;
	
    public UserCommuController(){
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("daoFactory.xml");
        userService = (UserService) applicationContext.getBean("userService");
    }
	
	@RequestMapping(value = "/user/info/{id}", method = RequestMethod.GET)
    public @ResponseBody User userInfo(@PathVariable String id) throws SQLException, ClassNotFoundException  {
		User user = userService.userInfo(id);
		return user;
    }
	
	@RequestMapping(value = "/user/add/{id}", method = RequestMethod.GET)
    public @ResponseBody User userAdd(@PathVariable String id) throws SQLException, ClassNotFoundException  {
		User user = userService.add(id);
		return user;
    }
}
