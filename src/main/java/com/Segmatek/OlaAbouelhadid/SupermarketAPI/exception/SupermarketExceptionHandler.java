package com.Segmatek.OlaAbouelhadid.SupermarketAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SupermarketExceptionHandler {

    //exception for not found
        @ExceptionHandler
        public ResponseEntity<ErrorResponse> handleException(SupermarketNotFoundException exc) {

            ErrorResponse error = new ErrorResponse();
            error.setStatus(HttpStatus.NOT_FOUND.value());
            error.setMessage(exc.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        //global exception for bad request
        @ExceptionHandler
        public ResponseEntity<ErrorResponse> handleException(Exception exc) {

                ErrorResponse error = new ErrorResponse();
                error.setStatus(HttpStatus.BAD_REQUEST.value());
                error.setMessage(exc.getMessage());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
}
