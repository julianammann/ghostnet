/*
 * Copyright (c) 2022. Julian Ammann
 */

package org.sheasepherd.ghostnet;

import jakarta.persistence.Entity;

@Entity
public class Rescuer extends Person{

    public Rescuer() {};

    public Rescuer(String firstname, String lastname, String phoneNumber) {
        super(firstname, lastname, phoneNumber);
    }


}
