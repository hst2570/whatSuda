package com.example.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 2016-06-21.
 */
@Entity
public class RecommendedRoute {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;
    private String userid;
    @JoinColumn(name = "beaconid")
    @ManyToOne
    private Beacon beacon; //추천된 비콘

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Beacon getBeacon() {
        return beacon;
    }

    public void setBeacon(Beacon beacon) {
        this.beacon = beacon;
    }
}
