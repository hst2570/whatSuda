package com.example.model;

import javax.persistence.*;

/**
 * Created by User on 2016-06-21.
 */
@Entity
public class RecommendedRoute {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long routeid;
    private String userid;
    @JoinColumn(name = "beaconid")
    @ManyToOne
    private Beacon beacon; //추천된 비콘

    public Long getRouteid() {
        return routeid;
    }

    public void setRouteid(Long routeid) {
        this.routeid = routeid;
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
