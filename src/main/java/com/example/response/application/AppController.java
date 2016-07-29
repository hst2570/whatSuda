package com.example.response.application;

import com.example.beacon.domain.Beacon;
import com.example.beacon.infra.BeaconRepository;
import com.example.response.domain.Location;
import com.example.response.domain.Photo;
import com.example.response.domain.RecommendedRoute;
import com.example.response.infra.LocationRepository;
import com.example.response.infra.PhotoRepository;
import com.example.response.infra.RecommendedRouteRepository;
import com.example.response.infra.StoryRepository;
import com.example.camera.application.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
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

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private LocationRepository locationRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET) //beaconid, userid 가 파라미터로 들어온다.
    public Object event(HttpServletRequest request) throws SQLException, IOException, ClassNotFoundException {
        Beacon beacon = beaconRepository.findOne(request.getParameter("beaconid"));
        String userid = request.getParameter("userid");

        if(beacon.getType() == 1){
            return cameraService.startCamera(userid, beacon.getBeaconid());
        }else if(beacon.getType() == 2){
            return storyRepository.findByBeacon(beacon);
        }else if(beacon.getType() == 3){
            Location location = new Location();
            Date date = new Date();
            location.setUserId(userid);
            location.setBeaconid(beacon);
            location.setDate(date);
            return locationRepository.save(location);
        }

        return null;
    }

    @RequestMapping(value = "/photo/{userid}", method = RequestMethod.GET)
    public List<Photo> getPhoto(@PathVariable String userid){
        return photoRepository.findByUserid(userid);
    }

    @RequestMapping(value = "/path/{userid}")
    public List<RecommendedRoute> route(@PathVariable String userid){
        System.out.println( recommendedRouteRepository.findByUserid(userid).get(0).getBeacon().getLocation());

        return recommendedRouteRepository.findByUserid(userid);
    }

}
