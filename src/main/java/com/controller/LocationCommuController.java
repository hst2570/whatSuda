package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.Camera;
import com.service.CameraService;

@ContextConfiguration("classpath:/daoFactory.xml")
@Controller
public class LocationCommuController {
	private CameraService cameraService;
    public LocationCommuController(){
		AbstractApplicationContext  applicationContext
                = new ClassPathXmlApplicationContext("daoFactory.xml");
        cameraService = (CameraService) applicationContext.getBean("cameraService");
    }
    
    @RequestMapping("/camera/start/{userid}/{beaconid}")
    public @ResponseBody Camera startCamera(@PathVariable int userid ,@PathVariable int beaconid) throws ClassNotFoundException, IOException, SQLException {
        return cameraService.startCamera(userid, beaconid);
    }
}
