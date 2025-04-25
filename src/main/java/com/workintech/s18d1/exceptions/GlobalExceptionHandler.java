package com.workintech.s18d1.exceptions;

import com.workintech.s18d1.entity.Burger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<BurgerErrorResponse> handleExceptions (BurgerException exception){
        log.error("Burger exception occured. Details: ",exception);
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    private ResponseEntity<BurgerErrorResponse> handleExceptions (Exception exception){
        log.error("A different exception occured. Details: ",exception);
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
