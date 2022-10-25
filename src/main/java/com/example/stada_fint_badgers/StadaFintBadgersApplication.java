package com.example.stada_fint_badgers;

import com.example.stada_fint_badgers.entities.Booking;
import com.example.stada_fint_badgers.entities.Customer;
import com.example.stada_fint_badgers.repo.BookingRepo;
import com.example.stada_fint_badgers.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

// Magnus was here
// Marie var också här
// Kevin var här

@SpringBootApplication
public class StadaFintBadgersApplication implements CommandLineRunner {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    BookingRepo bookingRepo;

    public static void main(String[] args) {
        SpringApplication.run(StadaFintBadgersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Customer customer = customerRepo.save(
                new Customer("Gunnar Gunnarson", "Stockholm")
        );
        bookingRepo.saveAll(List.of(
                new Booking(customer, "Idag för fan", "NU NU NU")
        )

        );
    }


}
