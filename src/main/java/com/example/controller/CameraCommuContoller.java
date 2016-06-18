package com.example.controller;

import com.example.model.Camera;
import com.example.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@RestController
public class CameraCommuContoller {

    @Autowired
    private CameraService cameraService;

    @RequestMapping("/camera/start/{userid}/{beaconid}")
    public @ResponseBody Camera startCamera(@PathVariable int userid, @PathVariable int beaconid) throws ClassNotFoundException, IOException, SQLException {
        return cameraService.startCamera(userid, beaconid);
    }

    @RequestMapping(value = "/camera/set", method = RequestMethod.GET)
    public @ResponseBody Camera setCamera(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        return cameraService.setCameraDomain(request);
    }

    @RequestMapping(value = "/camera/download", method = RequestMethod.GET)
    public void savePhoto(@RequestParam("file") String file) {
//		cameraService.savePhoto(userId, photoPath);
    }

}
