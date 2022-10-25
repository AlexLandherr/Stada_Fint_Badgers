package com.example.stada_fint_badgers.services;

import com.example.stada_fint_badgers.entities.Customer;
import com.example.stada_fint_badgers.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer addCustomer(String customerName, String address) {
        return customerRepo.save(new Customer(customerName, address));
    }

    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }
}
