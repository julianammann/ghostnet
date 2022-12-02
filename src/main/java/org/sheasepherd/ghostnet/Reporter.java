/*
 * Copyright (c) 2022. Julian Ammann
 */

package org.sheasepherd.ghostnet;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class Reporter extends Person implements Serializable {
    public Reporter() {
    };

    public Reporter(String firstname, String lastname, String phoneNumber) {
        super(firstname, lastname, phoneNumber);
    }

    @OneToOne(mappedBy = "reporter", orphanRemoval = true)
    private GhostNet ghostNet;

    public GhostNet getGhostNet() {
        return ghostNet;
    }

    public void setGhostNet(GhostNet ghostNet) {
        this.ghostNet = ghostNet;
    }
}
