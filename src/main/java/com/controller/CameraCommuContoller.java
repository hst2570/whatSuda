package com.controller;

import java.sql.SQLException;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.Camera;
import com.service.CameraService;

@Controller
public class CameraCommuContoller {
	private CameraService cameraService;
	
	@Before
    public void setup(){
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("daoFactory.xml");
        cameraService = (CameraService) applicationContext.getBean("cameraService");
    }
	
	@RequestMapping("/camera/start/{userid}/{beaconid}")
    public void startCamera(@PathVariable int userid ,@PathVariable int beaconid) {
        cameraService.startCamera(userid, beaconid);
    }
	
	@RequestMapping("/camera/set/{domain}/{cameraid}/{beaconid}")
	public Camera setCamera(@PathVariable String domain, @PathVariable int cameraid, @PathVariable int beaconid) throws SQLException{
		return cameraService.setCameraDomain(domain, cameraid, beaconid);
	}
	
	public void savePhoto(){
//		cameraService.savePhoto(userId, photoPath);
	}
}
