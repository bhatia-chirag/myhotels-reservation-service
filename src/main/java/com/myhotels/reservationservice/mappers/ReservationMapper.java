package com.myhotels.reservationservice.mappers;

import com.myhotels.reservationservice.dtos.ReservationRequestDto;
import com.myhotels.reservationservice.dtos.ReservationResponseDto;
import com.myhotels.reservationservice.entities.Reservation;
import org.mapstruct.Mapper;

@Mapper
public interface ReservationMapper {
    Reservation reservationRequestDtoToReservation(ReservationRequestDto requestDto);

    ReservationResponseDto reservationToReservationResponseDto(Reservation reservation);
}
