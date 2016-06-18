package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Camera {

    @Id
    private int id;
    private String domain;
    private int Cameraid;
    private int beaconid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getCameraid() {
        return Cameraid;
    }

    public void setCameraid(int cameraid) {
        Cameraid = cameraid;
    }

    public int getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(int beaconid) {
        this.beaconid = beaconid;
    }
}
