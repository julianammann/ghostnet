package org.sheasepherd.ghostnet;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class GhostNet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double latitude;
    private double longitude;
    private String estimatedSize;
    private String state = GhostNetState.Reported.getState();
    @Enumerated(EnumType.STRING)
    private GhostNetState ghostNetStateEnum = GhostNetState.Reported;

    private Rescuer rescuer;

    @ManyToOne
    @JoinColumn(name = "rescuer_id")
    public Rescuer getRescuer() {
        return rescuer;
    }

    public void setRescuer(Rescuer rescuer) {
        this.rescuer = rescuer;
    }

    public GhostNet() {
    }

    public GhostNet(double latitude, double longitude, String estimatedSize, String state)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.estimatedSize = estimatedSize;
        this.state = state;
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

    public GhostNetState getGhostNetStateEnum() {
        return ghostNetStateEnum;
    }

    public void setGhostNetStateEnum(GhostNetState ghostNetStateEnum) {
        this.ghostNetStateEnum = ghostNetStateEnum;
    }
}
