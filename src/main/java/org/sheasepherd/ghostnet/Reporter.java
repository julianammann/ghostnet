package org.sheasepherd.ghostnet;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@SessionScoped
@Named
@Entity
public class Reporter extends Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phoneNumber;

    public Reporter(){
    }

    public Reporter(String firstname, String lastname, String phoneNumber) {
        super(firstname, lastname);
        this.phoneNumber = phoneNumber;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(long id) {
        this.id = id;
    }
}
