package com.example.stada_fint_badgers.dto;

import com.example.stada_fint_badgers.entities.Booking;

import java.util.List;

public record CustomerResponseDTO(int id, String customerName, String address, List<BookingResponseDTO> bookingList) {
}
