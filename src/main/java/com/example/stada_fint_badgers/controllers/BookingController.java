package com.example.stada_fint_badgers.controllers;

import com.example.stada_fint_badgers.dto.BookingResponseDTO;
import com.example.stada_fint_badgers.dto.CreateBookingDTO;
import com.example.stada_fint_badgers.dto.CreateCustomerDTO;
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

    @GetMapping("/get")
    public List<BookingResponseDTO> getBookings(){
        return bookingService.getBookings();
    }

    @PostMapping("/new")
    public BookingResponseDTO addBooking(@RequestBody CreateBookingDTO createBookingDTO) {
        return bookingService.addBooking(
                createBookingDTO.customerName(),
                createBookingDTO.date(),
                createBookingDTO.time()
        ).toBookingResponseDTO();
    }

    @GetMapping("/getspec")
    public List<BookingResponseDTO> getSpecBookings(@RequestBody CreateCustomerDTO createCustomerDTO){
        String customerName = createCustomerDTO.customerName();
        return bookingService.getSpecBookings(customerName);
    }

    @DeleteMapping("kill")
    public void killBooking(@RequestBody BookingResponseDTO bookingResponseDTO){
        int id = bookingResponseDTO.id();
        bookingService.deleteById(id);
    }

    @PutMapping("/accept")
    public void acceptCleaning(@RequestBody BookingResponseDTO bookingResponseDTO){
        bookingService.acceptCleaning(bookingResponseDTO.id());
    }

}
