package com.xyz.springtest1.exception;

import com.xyz.springtest1.message.ErrorMessage;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(e.getMessage());
        errorMessage.setTimestamp(LocalDateTime.now());

        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(e.getMessage());
        errorMessage.setTimestamp(LocalDateTime.now());
        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationException(ConstraintViolationException e) {
        List<ErrorMessage> errormessageList = new ArrayList<>();

        e.getConstraintViolations().forEach
                (error -> {
                    ErrorMessage errorMessage = new ErrorMessage();
                    errorMessage.setMessage(error.getMessage());
                    errorMessage.setTimestamp(LocalDateTime.now());
                    errormessageList.add(errorMessage);
                });

        return new ResponseEntity(errormessageList, HttpStatus.NOT_FOUND);
    }
}
