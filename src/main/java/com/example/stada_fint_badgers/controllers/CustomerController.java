package com.example.stada_fint_badgers.controllers;

import com.example.stada_fint_badgers.dto.CreateCustomerDTO;
import com.example.stada_fint_badgers.dto.CustomerResponseDTO;
import com.example.stada_fint_badgers.services.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponseDTO addCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        return customerService.addCustomer(
                createCustomerDTO.customer(),
                createCustomerDTO.address(),
                createCustomerDTO.bookingList()
        ).toCustomerResponseDTO();
    }
}
