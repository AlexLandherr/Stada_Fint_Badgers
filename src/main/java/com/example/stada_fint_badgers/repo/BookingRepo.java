package com.example.stada_fint_badgers.repo;

import com.example.stada_fint_badgers.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
}
