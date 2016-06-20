package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Camera {

    @Id
    private String beaconid;
    private String domain;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(String beaconid) {
        this.beaconid = beaconid;
    }
}
