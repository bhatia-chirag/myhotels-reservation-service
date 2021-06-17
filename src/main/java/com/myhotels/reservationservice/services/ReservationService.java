package com.myhotels.reservationservice.services;

import com.myhotels.reservationservice.dtos.ReservationRequestDto;
import com.myhotels.reservationservice.entities.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation getReservation(String bookingId);
    List<Reservation> getAllReservations();
    Reservation makeReservation(ReservationRequestDto reservationRequestDto);
    Reservation cancelReservation(String bookingId);
    Reservation updateReservation(Reservation reservation, String bookingId);
}
