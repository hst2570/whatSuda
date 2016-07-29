package com.example.camera.domain;

import com.example.beacon.domain.Beacon;
import com.example.camera.infra.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Camera {
    /*
        카메라 도메인
        - 카메라 셋팅
        - 카메라 정보 수정
        - 비콘과 카메라 맵핑
     */
    @EmbeddedId
    private CameraNo cameraNo;

    @JoinColumn(name = "beaconid")
    @ManyToOne
    private Beacon beaconid;
    @Embedded
    private Domain domain;

    @Autowired
    private CameraRepository cameraRepository;

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Beacon getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(Beacon beaconid) {
        this.beaconid = beaconid;
    }

    public CameraNo getCameraNo() {
        return cameraNo;
    }

    public void setCameraNo(CameraNo cameraNo) {
        this.cameraNo = cameraNo;
    }


    public Camera addCameraInfo(Camera cameraInfo) {
        if (cameraInfo.equals(null)) throw new IllegalArgumentException("no camera information!");
        return cameraRepository.save(cameraInfo);
    }
}
