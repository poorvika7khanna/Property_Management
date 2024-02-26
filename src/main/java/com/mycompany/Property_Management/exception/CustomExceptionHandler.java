package com.mycompany.Property_Management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice                // tells spring boot to look for this class for exception handling
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class)    // For business exceptions
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex)
    {
        return new ResponseEntity<List<ErrorModel>>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
