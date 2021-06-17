package com.myhotels.reservationservice.services;

import com.myhotels.reservationservice.dtos.BookingDto;
import com.myhotels.reservationservice.dtos.ReservationRequestDto;
import com.myhotels.reservationservice.entities.Reservation;
import com.myhotels.reservationservice.feign.HotelExchangeProxy;
import com.myhotels.reservationservice.mappers.ReservationMapper;
import com.myhotels.reservationservice.repos.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ReservationRepo repo;
    @Autowired
    private HotelExchangeProxy hotelProxy;
    @Autowired
    private ReservationMapper mapper;

    @Override
    public Reservation getReservation(String bookingId) {
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }

    @Transactional
    @Override
    public Reservation makeReservation(ReservationRequestDto reservationRequestDto) {
        BookingDto booking = new BookingDto();
        // TODO: Create and use mapper.
        booking.setEndDate(reservationRequestDto.getEndDate());
        booking.setHotelName(reservationRequestDto.getHotelName());
        booking.setRoomType(reservationRequestDto.getRoomType());
        booking.setStartDate(reservationRequestDto.getStartDate());
        String bookingId = UUID.randomUUID().toString();
        hotelProxy.createHotelBooking(booking, bookingId);
        Reservation reservation = mapper.reservationRequestDtoToReservation(reservationRequestDto);
        reservation.setBookingId(bookingId);
        reservation.setGuestPhoneNumber(reservationRequestDto.getPhoneNumber());
        reservation.setTotalPrice(123456L);
        return repo.save(reservation);
    }

    @Override
    public Reservation cancelReservation(String bookingId) {
        Reservation reservation = repo.findByBookingId(bookingId).orElseThrow(()-> {
            // TODO: Throw custom exception
            throw new IllegalArgumentException("ReservationId not found");
        });
        repo.deleteById(reservation.getId());
        return reservation;
    }

    @Override
    public Reservation updateReservation(Reservation reservation, String bookingId) {
        return null;
    }
}
