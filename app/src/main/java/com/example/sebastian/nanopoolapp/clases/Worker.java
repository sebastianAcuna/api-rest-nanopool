package com.example.sebastian.nanopoolapp.clases;

import java.util.HashMap;
import java.util.Map;

public class Worker {
    private String id;
    private Integer uid;
    private String hashrate;
    private Integer lastshare;
    private Integer rating;
    private String h1;
    private String h3;
    private String h6;
    private String h12;
    private String h24;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getHashrate() {
        return hashrate;
    }

    public void setHashrate(String hashrate) {
        this.hashrate = hashrate;
    }

    public Integer getLastshare() {
        return lastshare;
    }

    public void setLastshare(Integer lastshare) {
        this.lastshare = lastshare;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getH3() {
        return h3;
    }

    public void setH3(String h3) {
        this.h3 = h3;
    }

    public String getH6() {
        return h6;
    }

    public void setH6(String h6) {
        this.h6 = h6;
    }

    public String getH12() {
        return h12;
    }

    public void setH12(String h12) {
        this.h12 = h12;
    }

    public String getH24() {
        return h24;
    }

    public void setH24(String h24) {
        this.h24 = h24;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
