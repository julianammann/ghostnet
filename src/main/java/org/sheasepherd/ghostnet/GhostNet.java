package org.sheasepherd.ghostnet;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.io.Serializable;

@SessionScoped
@Named
@Entity
public class GhostNet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double latitude;
    private double longitude;
    private String estimatedSize;
    private String state;

    public GhostNet() {
    }

    public GhostNet(double latitude, double longitude, String estimatedSize)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.estimatedSize = estimatedSize;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEstimatedSize(String estimatedSize) {
        this.estimatedSize = estimatedSize;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEstimatedSize() {
        return estimatedSize;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getState() {
        return state;
    }

}
