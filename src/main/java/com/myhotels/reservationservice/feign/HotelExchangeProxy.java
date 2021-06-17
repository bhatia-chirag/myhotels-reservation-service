package com.myhotels.reservationservice.feign;

import com.myhotels.reservationservice.dtos.BookingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "hotel-service", url = "localhost:8000")
public interface HotelExchangeProxy {

    @PostMapping("/hotels/booking/{bookingId}")
    ResponseEntity<BookingDto> createHotelBooking(@RequestBody BookingDto bookingDto, @PathVariable String bookingId);
}
