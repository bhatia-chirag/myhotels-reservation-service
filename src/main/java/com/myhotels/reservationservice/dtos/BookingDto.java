package com.myhotels.reservationservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookingDto {

    private String hotelName;
    private String roomType;
    private LocalDate startDate;
    private LocalDate endDate;

}
