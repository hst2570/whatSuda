package com.example;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.domain.Camera;
import com.example.service.CameraService;

public class CameraServiceTest {
	private CameraService cameraService;
	@Before
    public void setup(){
		AbstractApplicationContext  applicationContext
                = new ClassPathXmlApplicationContext("daoFactory.xml");
        cameraService = (CameraService) applicationContext.getBean("cameraService");
    }
	
//	@RequestMapping("/camera/start/{userid}/{beaconid}")
//	@Test
//    public void startCamera() throws ClassNotFoundException, IOException, SQLException {
//		int userid = 3;
//		int beaconid = 3;
//        cameraService.startCamera(userid, beaconid);
//    }
	
	@Test
	public void setCamera() throws SQLException, ClassNotFoundException{
		int cameraid = 5;
		int beaconid = 5;
		String domain = "test";
		
		Camera camera = cameraService.setCameraDomain(domain, cameraid, beaconid);
		
		assertEquals(cameraid, camera.getCameraid());
		assertEquals(beaconid, camera.getBeaconid());
		assertEquals(domain, camera.getDomain());
	}
	
//	public void savePhoto(){
////		cameraService.savePhoto(userId, photoPath);
//	}
}
