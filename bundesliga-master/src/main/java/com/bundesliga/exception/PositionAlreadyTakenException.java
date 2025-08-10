package com.bundesliga.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.CONFLICT)
public class PositionAlreadyTakenException extends RuntimeException {
    public PositionAlreadyTakenException(String message) {
        super(message);
    }
}
