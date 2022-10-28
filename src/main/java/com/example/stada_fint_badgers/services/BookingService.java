package com.example.stada_fint_badgers.services;

import com.example.stada_fint_badgers.dto.BookingResponseDTO;
import com.example.stada_fint_badgers.entities.Booking;
import com.example.stada_fint_badgers.entities.Customer;
import com.example.stada_fint_badgers.repo.BookingRepo;
import com.example.stada_fint_badgers.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookingService {

    private final BookingRepo bookingRepo;
    private final CustomerRepo customerRepo;

    public BookingService(BookingRepo bookingRepo, CustomerRepo customerRepo) {
        this.bookingRepo = bookingRepo;
        this.customerRepo = customerRepo;
    }

    public Booking addBooking(String customerName, String date, String time) {
        List<Customer> customers = customerRepo.findAll();
        Customer customer = customers.stream().
                filter(c -> Objects.equals(c.getCustomerName(), customerName))
                .findFirst().orElseThrow();
        return bookingRepo.save(new Booking(customer, date, time));
    }

    public List<BookingResponseDTO> getBookings() {
        return bookingRepo.findAll().stream().
                map((booking) -> {
                    return booking.toBookingResponseDTO();
                })
                .toList();
    }

    public List<BookingResponseDTO> getSpecBookings(String customerName) {
        List<BookingResponseDTO> result = bookingRepo.
                findAll().
                stream().
                filter(b -> Objects.equals(b.getCustomer().getCustomerName(), customerName)).
                map(b -> b.toBookingResponseDTO()).toList();
        return  result;
    }

    public void deleteById(int id) {
        bookingRepo.deleteById(id);
    }

    public void acceptCleaning(int id) {
        Booking booking = bookingRepo.findById(id).orElseThrow();
        booking.setAccepted(true);
        bookingRepo.save(booking);


    }
}