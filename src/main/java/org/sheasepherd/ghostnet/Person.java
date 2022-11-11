package org.sheasepherd.ghostnet;

public class Person {

    private String lastname;
    private String firstname;
    private String fullName;

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

}
