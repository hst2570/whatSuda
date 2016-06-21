package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Camera {
    @Id
    private String cameraid;

    @JoinColumn(name = "beaconid")
    @ManyToOne
    private Beacon beaconid;
    private String domain;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Beacon getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(Beacon beaconid) {
        this.beaconid = beaconid;
    }

    public String getCameraid() {
        return cameraid;
    }

    public void setCameraid(String cameraid) {
        this.cameraid = cameraid;
    }
}
