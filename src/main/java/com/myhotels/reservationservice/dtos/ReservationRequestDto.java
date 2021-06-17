package com.myhotels.reservationservice.dtos;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
public class ReservationRequestDto {
    @NotNull
    @Length(min = 1, max = 255)
    private String hotelName;

    @NotNull
    @Length(min = 1, max = 255)
    private String guestName;

    @Min(value = 7000000000L)
    @Max(value = 9999999999L)
    private Long phoneNumber;

    @FutureOrPresent
    private LocalDate startDate;

    @Future
    private LocalDate endDate;

    @NotNull
    @Length(min = 1, max = 255)
    private String roomType;
}
