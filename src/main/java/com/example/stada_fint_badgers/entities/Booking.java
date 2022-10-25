package com.example.stada_fint_badgers.entities;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String testField;

    @ManyToOne
    private Customer customer;


    public Booking(String testField) {
        this.testField = testField;
    }

    public Booking() {
    }

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }
}
