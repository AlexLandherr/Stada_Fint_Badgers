package com.example.stada_fint_badgers.dto;

import com.example.stada_fint_badgers.entities.Customer;

public record BookingResponseDTO(String customerName, String status, String date, String time) {
}
