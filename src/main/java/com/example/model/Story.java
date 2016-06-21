package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by User on 2016-06-21.
 */
@Entity
public class Story {
    @Id
    @JoinColumn(name = "beaconid")
    @ManyToOne
    private Beacon beaconid;
    private String content;

    public Beacon getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(Beacon beaconid) {
        this.beaconid = beaconid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
