package org.sheasepherd.ghostnet;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@SessionScoped
@Named
@Entity
public class Reporter extends Person implements Serializable {

    @Id
    private int id;

    private String phoneNumber;

    public Reporter(){

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }
}
