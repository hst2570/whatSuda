package com.example.beacon.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by User on 2016-06-21.
 */
@Entity
public class Beacon implements Serializable {

    @EmbeddedId
    private BeaconNo beaconid;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private BeaconType type; // 1, 2, 3으로 나뉨. 1 파파라치, 2 스토리, 3 경로 저장

    @Embedded
    private BeaconLocation location;

    public BeaconType getType() {
        return type;
    }

    public void setType(BeaconType type) {
        this.type = type;
    }

    public BeaconLocation getLocation() {
        return location;
    }

    public void setLocation(BeaconLocation location) {
        this.location = location;
    }

    public BeaconNo getBeaconid() {

        return beaconid;
    }

    public void setBeaconid(BeaconNo beaconid) {
        this.beaconid = beaconid;
    }
}
