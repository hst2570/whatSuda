package com.example.camera.application;

import com.example.camera.infra.CameraRepository;
import com.example.camera.domain.Camera;
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
    public Camera startCamera(String userId, String beaconid) throws IOException, ClassNotFoundException, SQLException {
        Camera camera = cameraRepository.findOne(beaconid);

        URL url = new URL(camera.getDomain() + "?userid=" + userId);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        if (urlConnection.getResponseCode() == 404) { // 해당 카메라에 접속이 안되면 모든 값을 null로 변경.
            camera.setDomain(null);
            camera.setBeaconid(null);
        }

        return camera;
    }

    @Override
    public void savePhoto(Long userId, String photoPath) {
        /*
            - 특정 URL로 파일이 저장되게.
            - 파일은 POST로 받는다.
            - image인지 아닌지
         */
    }

    @Override
    public Camera setCameraDomain(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        return null;
    }

//    @Override
//    public Camera setCameraDomain(HttpServletRequest request) throws SQLException, ClassNotFoundException {
//        Camera camera = new Camera();
//        camera.setBeaconid(request.getParameter("beaconid"));
//        camera.setDomain(request.getParameter("domain"));
//
//        return cameraRepository.save(camera);
//    }
}
