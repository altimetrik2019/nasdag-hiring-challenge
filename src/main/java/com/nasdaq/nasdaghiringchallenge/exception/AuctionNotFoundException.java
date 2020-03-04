package com.nasdaq.nasdaghiringchallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuctionNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -6389090343706254333L;

    /**
     * 
     */
    public AuctionNotFoundException() {
        super();
    }

    /**
     * @param message
     */
    public AuctionNotFoundException(String message) {
        super(message);
    }

}
