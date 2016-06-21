package com.example.controller;

import com.example.model.Beacon;
import com.example.model.Photo;
import com.example.model.RecommendedRoute;
import com.example.repository.BeaconRepository;
import com.example.repository.PhotoRepository;
import com.example.repository.RecommendedRouteRepository;
import com.example.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 2016-06-21.
 */
@RestController
public class AppController {

    @Autowired
    private CameraService cameraService;

    @Autowired
    private BeaconRepository beaconRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private RecommendedRouteRepository recommendedRouteRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET) //beaconid, userid 가 파라미터로 들어온다.
    public Object event(HttpServletRequest request) throws SQLException, IOException, ClassNotFoundException {
        Beacon beacon = beaconRepository.findOne(request.getParameter("beaconid"));
        String userid = request.getParameter("userid");

        if(beacon.getType() == 1){
            return cameraService.startCamera(userid, beacon.getBeaconid());
        }else if(beacon.getType() == 2){
            // story
        }else if(beacon.getType() == 3){
            // location
        }

        return null;
    }

    @RequestMapping(value = "/photo/{userid}", method = RequestMethod.GET)
    public List<Photo> getPhoto(@PathVariable String userid){
        return photoRepository.findByUserid(userid);
    }

    @RequestMapping(value = "/path/{userid}", method = RequestMethod.GET)
    public List<RecommendedRoute> route(@PathVariable String userid){
        return recommendedRouteRepository.findByUserid(userid);
    }

}
