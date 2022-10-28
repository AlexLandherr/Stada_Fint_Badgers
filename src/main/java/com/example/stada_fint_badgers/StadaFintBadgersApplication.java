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
        Customer customer1 = customerRepo.save(
                new Customer("Billy the kid", "vilda västern")
        );

        Booking booking1 = new Booking(customer, "2022/02/11", "01:00");
        booking1.setDone(true);
        Booking booking2 = new Booking(customer, "2022/02/12", "02:00");
        booking2.setDone(true);



        bookingRepo.saveAll(List.of(
                booking1,
                booking2,
                new Booking(customer, "2022/02/13", "03:00"),
                new Booking(customer, "2022/02/14", "04:00"),
                new Booking(customer, "2022/02/15", "05:00"),
                new Booking(customer1, "idag", "med en gång annars skjuter jag er")

        )

        );


    }


}
