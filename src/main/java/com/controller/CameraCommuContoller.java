package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
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
public class CameraCommuContoller {
	private CameraService cameraService;
	
    public CameraCommuContoller(){
		AbstractApplicationContext  applicationContext
                = new ClassPathXmlApplicationContext("daoFactory.xml");
        cameraService = (CameraService) applicationContext.getBean("cameraService");
    }
	
	@RequestMapping("/camera/start/{userid}/{beaconid}")
    public @ResponseBody Camera startCamera(@PathVariable int userid ,@PathVariable int beaconid) throws ClassNotFoundException, IOException, SQLException {
        return cameraService.startCamera(userid, beaconid);
    }
	
	@RequestMapping("/camera/set/{domain}/{cameraid}/{beaconid}")
	public @ResponseBody Camera setCamera(@PathVariable String domain, @PathVariable int cameraid, @PathVariable int beaconid) throws SQLException, ClassNotFoundException{
		return cameraService.setCameraDomain(domain, cameraid, beaconid);
	}
	
	public void savePhoto(){
//		cameraService.savePhoto(userId, photoPath);
	}
}
