package com.example.stada_fint_badgers.controllers;

import com.example.stada_fint_badgers.dto.BookingResponseDTO;
import com.example.stada_fint_badgers.dto.CreateBookingDTO;
import com.example.stada_fint_badgers.dto.CustomerResponseDTO;
import com.example.stada_fint_badgers.entities.Booking;
import com.example.stada_fint_badgers.entities.Customer;
import com.example.stada_fint_badgers.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/new")
    public BookingResponseDTO addBooking(@RequestBody CreateBookingDTO createBookingDTO) {
        return bookingService.addBooking(
                createBookingDTO.customerName(),
                createBookingDTO.date(),
                createBookingDTO.time()
        ).toBookingResponseDTO();
    }

    @GetMapping("/get")
    public List<BookingResponseDTO> getBookings(){
        return bookingService.getBookings();
    }
}
