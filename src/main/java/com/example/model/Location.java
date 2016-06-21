package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String locationid;
    @JoinColumn(name = "beaconid")
    @ManyToOne
    private Beacon beaconid;
    private String userId;
    private Date date;

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Beacon getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(Beacon beaconid) {
        this.beaconid = beaconid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
