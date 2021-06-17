package com.myhotels.reservationservice.controllers;

import com.myhotels.reservationservice.dtos.ReservationRequestDto;
import com.myhotels.reservationservice.dtos.ReservationResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reservation")
public interface ReservationController {
    @GetMapping("/bookingId/{bookingId}")
    ReservationResponseDto getReservation(@PathVariable("bookingId") String bookingId);

    @GetMapping("/")
    List<ReservationResponseDto> getAllReservations();

    @PostMapping
    ReservationResponseDto makeReservation(@RequestBody ReservationRequestDto reservationRequestDto);

    @DeleteMapping("/bookingId/{bookingId}")
    ReservationResponseDto cancelReservation(@PathVariable("bookingId") String bookingId);

    @PutMapping("/bookingId/{bookingId}")
    ReservationResponseDto updateReservation(@RequestBody ReservationRequestDto reservationRequestDto, @PathVariable String bookingId);
}
