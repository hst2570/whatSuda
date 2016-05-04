package com.example;

import static org.junit.Assert.assertEquals;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dao.CameraDao;
import com.domain.Camera;

public class CameraDaoTest {
	private CameraDao cameraDao;
	
	@Before
    public void setup(){
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("daoFactory.xml");
        cameraDao = (CameraDao) applicationContext.getBean("cameraDao");
    }
	
//    @Test
//    public void get() throws SQLException, ClassNotFoundException {
//    	int id = 1;
//        Camera camera = cameraDao.get(id);
//        assertEquals(id, camera.getBeaconid());
//    }
    
    @Test
    public void connecCamera() throws SQLException, ClassNotFoundException {
    	int id = 1;
        Camera camera = cameraDao.get(id);
        
        String encoded = null;
        DataOutputStream  out = null;
        try{
            URL url = new URL(camera.getDomain());
            URLConnection conn = url.openConnection();
            HttpURLConnection hurlc = (HttpURLConnection) conn;
            // 헤더값을 설정한다.
//            hurlc.setRequestProperty(키, 값);
//            hurlc.setRequestMethod("get");
            hurlc.setDoOutput(true);
            hurlc.setDoInput(true);
            hurlc.setUseCaches(false);
            hurlc.setDefaultUseCaches(false);
//            encoded = ;
            out = new DataOutputStream(conn.getOutputStream());
//            out.writeBytes(encoded);
            out.flush();
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                out.close();
            }catch(Exception e){}
        }
        
        assertEquals(id, camera.getBeaconid());
    }

}
