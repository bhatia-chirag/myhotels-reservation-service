package com.myhotels.reservationservice.controllers;

import com.myhotels.reservationservice.dtos.ReservationRequestDto;
import com.myhotels.reservationservice.dtos.ReservationResponseDto;
import com.myhotels.reservationservice.mappers.ReservationMapper;
import com.myhotels.reservationservice.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReservationControllerImpl implements ReservationController{
    @Autowired
    private ReservationService service;
    @Autowired
    private ReservationMapper mapper;

    @Override
    public ReservationResponseDto getReservation(String bookingId) {
        return mapper.reservationToReservationResponseDto(service.getReservation(bookingId));
    }

    @Override
    public List<ReservationResponseDto> getAllReservations() {
        return service.getAllReservations().stream()
                .map(reservation -> mapper.reservationToReservationResponseDto(reservation))
                .collect(Collectors.toList());
    }

    @Override
    public ReservationResponseDto makeReservation(ReservationRequestDto reservationRequestDto) {
        return mapper.reservationToReservationResponseDto(service.makeReservation(reservationRequestDto));
    }

    @Override
    public ReservationResponseDto cancelReservation(String bookingId) {
        return mapper.reservationToReservationResponseDto(service.cancelReservation(bookingId));
    }

    @Override
    public ReservationResponseDto updateReservation(ReservationRequestDto reservationRequestDto, String bookingId) {
        return mapper.reservationToReservationResponseDto(
                service.updateReservation(mapper.reservationRequestDtoToReservation(reservationRequestDto), bookingId));
    }
}
