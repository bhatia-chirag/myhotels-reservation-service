package com.myhotels.reservationservice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.myhotels.reservationservice.dtos.errors.ApiError;
import feign.FeignException;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FeignException.class)
    protected final ResponseEntity<ApiError> handleFeignException(FeignException e) throws JsonProcessingException {
        log.warning(e.getMessage());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return new ResponseEntity<>(objectMapper.readValue(e.contentUTF8(), ApiError.class), HttpStatus.valueOf(e.status()));
    }
}
