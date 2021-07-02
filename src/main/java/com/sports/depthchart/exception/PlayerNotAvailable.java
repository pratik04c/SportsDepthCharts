package com.sports.depthchart.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  
public class PlayerNotAvailable extends RuntimeException {
	public PlayerNotAvailable(String errorMessage) {
        super(errorMessage);
    }
}
