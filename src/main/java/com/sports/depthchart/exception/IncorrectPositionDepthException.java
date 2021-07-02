package com.sports.depthchart.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  
public class IncorrectPositionDepthException extends RuntimeException {
	public IncorrectPositionDepthException(String errorMessage) {
        super(errorMessage);
    }
}
