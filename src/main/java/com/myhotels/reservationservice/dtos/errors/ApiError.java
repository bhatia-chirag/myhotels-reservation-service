package com.myhotels.reservationservice.dtos.errors;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ApiError {
    private String message;
    private String rootCause;
    private LocalDateTime timeStamp;

    public ApiError(String message, String rootCause) {
        this.message = message;
        this.rootCause = rootCause;
        timeStamp = LocalDateTime.now();
    }
}
