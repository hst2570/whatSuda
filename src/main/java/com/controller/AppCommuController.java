package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.User;
import com.service.UserService;

@Controller
public class AppCommuController {
	private UserService appService;
	
	public void setAppService(UserService appService){
		this.appService = appService;
	}
	
	@RequestMapping("/user/info/{id}")
    public User userInfo(@PathVariable String id)  {
        return appService.userInfo(id);
    }
	
}
