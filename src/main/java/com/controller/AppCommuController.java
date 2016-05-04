package com.controller;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.User;
import com.service.CameraService;
import com.service.UserService;

@Controller
public class AppCommuController {
	private UserService userService;
	
	@Before
    public void setup(){
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("daoFactory.xml");
        userService = (UserService) applicationContext.getBean("userService");
    }
	
	public void setAppService(UserService appService){
		this.userService = appService;
	}
	
	@RequestMapping("/user/info/{id}")
    public User userInfo(@PathVariable String id)  {
		System.out.println("controller id : ----------------------------------------"+id+"--------------------------------------");
        return userService.userInfo(id);
    }
	
}
