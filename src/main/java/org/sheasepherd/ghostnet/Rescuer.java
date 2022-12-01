/*
 * Copyright (c) 2022. Julian Ammann
 */

package org.sheasepherd.ghostnet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Rescuer extends Person{
    private Set<GhostNet> ghostNets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "rescuer", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<GhostNet> getGhostNets() {
        return ghostNets;
    }

    public void setGhostNets(Set<GhostNet> ghostNets) {
        this.ghostNets = ghostNets;
    }

    public Rescuer() {};

    public Rescuer(String firstname, String lastname, String phoneNumber) {
        super(firstname, lastname, phoneNumber);
    }

    public String getRescuerName() {
        return getFirstname() + " " + getLastname();
    }
}
