package com.example.stada_fint_badgers.controllers;

import com.example.stada_fint_badgers.dto.CreateCustomerDTO;
import com.example.stada_fint_badgers.dto.CustomerResponseDTO;
import com.example.stada_fint_badgers.entities.Customer;
import com.example.stada_fint_badgers.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get")
    public CustomerResponseDTO getCustomers(@RequestBody CreateCustomerDTO createCustomerDTO){
        return customerService.getCustomers().stream()
                .filter(c -> Objects.equals(c.getCustomerName(), createCustomerDTO.customerName()))
                .map(Customer::toCustomerResponseDTO).toList().get(0);
    }

    @PostMapping("/register")
    public CustomerResponseDTO addCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        return customerService.addCustomer(
                createCustomerDTO.customerName(),
                createCustomerDTO.address()
        ).toCustomerResponseDTO();
    }
}
