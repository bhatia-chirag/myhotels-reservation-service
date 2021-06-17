package com.myhotels.reservationservice.repos;

import com.myhotels.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByBookingId(String bookingId);
}
