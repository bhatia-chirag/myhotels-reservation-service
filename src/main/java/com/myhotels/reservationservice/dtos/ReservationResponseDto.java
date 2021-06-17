package com.myhotels.reservationservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationResponseDto {
    private String bookingId;
    private String hotelName;
    private String guestName;
    private Long guestPhoneNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private String roomType;
    private Long totalPrice;
}
