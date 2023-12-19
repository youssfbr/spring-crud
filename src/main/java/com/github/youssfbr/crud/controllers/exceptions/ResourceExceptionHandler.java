package com.github.youssfbr.crud.controllers.exceptions;

import com.github.youssfbr.crud.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundException (
            ResourceNotFoundException e,
            HttpServletRequest request) {

        StandardError error = new StandardError(
                Instant.now().toString() ,
                NOT_FOUND.toString() ,
                e.getMessage() ,
                request.getRequestURI());

        return ResponseEntity.status(NOT_FOUND).body(error);
    }
}
