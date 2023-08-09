package com.example.first.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "first")
public class First {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "password")
    private String password;

    public First() {
    }

    public First(long id, String firstname, String lastname, String password) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "first [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
                + "]";
    }
}