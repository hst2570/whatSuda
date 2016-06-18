package com.example;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.dao.CameraDao;
import com.example.model.Camera;

public class CameraDaoTest {
	private CameraDao cameraDao;
	
	@Before
    public void setup(){
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("daoFactory.xml");
        cameraDao = (CameraDao) applicationContext.getBean("cameraDao");
    }
	
    @Test
    public void get() throws SQLException, ClassNotFoundException {
    	int id = 1;
        Camera camera = cameraDao.get(id);
        assertEquals(id, camera.getBeaconid());
    }
}
