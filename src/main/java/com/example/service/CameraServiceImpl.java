package com.example.service;

import com.example.model.Camera;
import com.example.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

@Service("CameraService")
public class CameraServiceImpl implements CameraService {

    @Autowired
    private CameraRepository cameraRepository;

    @Override
    public Camera startCamera(int userId, int beaconid) throws IOException, ClassNotFoundException, SQLException {
        Camera camera = cameraRepository.findOne(beaconid);

        URL url = new URL(camera.getDomain() + "?userid=" + userId);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        if (urlConnection.getResponseCode() == 404) {
            camera.setDomain(null);
            camera.setBeaconid(null);
            camera.setCameraid(null);
        }

        return camera;
    }

    @Override
    public void savePhoto(Long userId, String photoPath) {

    }

    @Override
    public Camera setCameraDomain(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        Camera camera = new Camera();
        camera.setBeaconid(request.getParameter("beaconid"));
        camera.setCameraid(request.getParameter("cameraid"));
        camera.setDomain(request.getParameter("domain"));

        return cameraRepository.save(camera);
    }
}
