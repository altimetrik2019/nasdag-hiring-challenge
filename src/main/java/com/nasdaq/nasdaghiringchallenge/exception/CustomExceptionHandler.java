package com.nasdaq.nasdaghiringchallenge.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BuyerNotFoundException.class)
    public final ResponseEntity<Object> handleBuyerNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ErrorModel.of(new Date(), ex.getMessage(), request.getDescription(false)),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SellerNotFoundException.class)
    public final ResponseEntity<Object> handleSellerNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ErrorModel.of(new Date(), ex.getMessage(), request.getDescription(false)),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuctionNotFoundException.class)
    public final ResponseEntity<Object> handleAuctionNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ErrorModel.of(new Date(), ex.getMessage(), request.getDescription(false)),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BidNotFoundException.class)
    public final ResponseEntity<Object> handleBidNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ErrorModel.of(new Date(), ex.getMessage(), request.getDescription(false)),
                HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ErrorModel.of(new Date(), "Validation Failed",
                ex.getBindingResult().getFieldError().getDefaultMessage()),
                HttpStatus.BAD_REQUEST);
    }

}
