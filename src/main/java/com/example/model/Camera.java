package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Camera {

    @Id
    private int beaconid;
    private String domain;
    private int Cameraid;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getCameraid() {
        return Cameraid;
    }

    public void setCameraid(String cameraid) {
        Cameraid = cameraid;
    }

    public int getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(String beaconid) {
        this.beaconid = beaconid;
    }

}
