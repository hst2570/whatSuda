package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by User on 2016-06-21.
 */
@Entity
public class Beacon implements Serializable {
    @Id
    private String beaconid;
    private int type; // 1, 2, 3으로 나뉨. 1 파파라치, 2 스토리, 3 경로 저장
    private String location;

    public String getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(String beaconid) {
        this.beaconid = beaconid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
