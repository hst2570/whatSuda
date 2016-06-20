package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by User on 2016-06-21.
 */
@Entity
public class Story {
    @Id
    private String beaconid;
    private String content;

    public String getBeaconid() {
        return beaconid;
    }

    public void setBeaconid(String beaconid) {
        this.beaconid = beaconid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
