package com.example.stada_fint_badgers.entities;

import com.example.stada_fint_badgers.dto.BookingResponseDTO;
import com.example.stada_fint_badgers.dto.CustomerResponseDTO;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;


    @ManyToOne
    private Customer customer;


    public Booking(Customer customer, String date, String time) {
        this.customer = customer;
        this.date = date;
        this.time = time;
        this.status = "Obekräftad";
    }

    public Booking() {
    }


    public String getTestField() {
        return status;
    }

    public void setTestField(String testField) {
        this.status = testField;
    }

    public BookingResponseDTO toBookingResponseDTO() {
        return new BookingResponseDTO(customer.getCustomerName(), status, date, time);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}