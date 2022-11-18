package org.sheasepherd.ghostnet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String lastname;
    private String firstname;
    private String fullName;


    public Person() {}

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    //getters

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    //setters

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFullName() {
        if(this.firstname.length() > 0 && this.lastname.length() > 0) {
            return this.firstname + " " + this.lastname;
        }
        return "anonym";

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
