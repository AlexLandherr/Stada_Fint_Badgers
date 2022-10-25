package com.example.stada_fint_badgers.entities;

import com.example.stada_fint_badgers.dto.CustomerResponseDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String customer;

    @Column(unique = true, nullable = false)
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Customer(String customer, String address) {
        this.customer = customer;
        this.address = address;
    }

    public Customer() {
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public CustomerResponseDTO toCustomerResponseDTO() {
        return new CustomerResponseDTO(id, customer, address, bookings);
    }
}
