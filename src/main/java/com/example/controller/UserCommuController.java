package com.example.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.User;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserCommuController {
    @Autowired
	private UserService userService;
	
	@RequestMapping("/info/{id}")
    public @ResponseBody User userInfo(@PathVariable String id) throws SQLException, ClassNotFoundException  {
		User user = userService.userInfo(id);
		return user;
    }
	
	@RequestMapping("/add/{id}")
    public @ResponseBody User userAdd(@PathVariable String id) throws SQLException, ClassNotFoundException  {
		User user = userService.add(id);
		return user;
    }
}
