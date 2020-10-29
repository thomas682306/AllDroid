package com.example.alldroid.MapPackage;

import java.io.Serializable;

public class MapComponentModel implements Serializable {
    private String status;
    private int resourceId;

    public MapComponentModel(String status, int resourceId) {
        this.status = status;
        this.resourceId = resourceId;
    }

    public MapComponentModel() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
