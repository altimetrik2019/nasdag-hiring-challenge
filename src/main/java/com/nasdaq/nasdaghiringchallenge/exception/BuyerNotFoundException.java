package com.nasdaq.nasdaghiringchallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BuyerNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 7507963034593085858L;

    public BuyerNotFoundException(String message) {
        super(message);
    }


}
