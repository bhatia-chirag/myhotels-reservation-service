package com.myhotels.reservationservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reservation_info")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String bookingId;

    @Column(nullable = false)
    private String hotelName;

    @Column(nullable = false)
    private String guestName;

    @Column(nullable = false)
    private Long guestPhoneNumber;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private String roomType;

    @Column(nullable = false)
    private Long totalPrice;

}
