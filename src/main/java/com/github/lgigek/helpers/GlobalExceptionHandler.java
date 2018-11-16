package com.github.lgigek.helpers;

import com.github.lgigek.helpers.exceptions.TaskAlreadyCreatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {TaskAlreadyCreatedException.class})
    public ResponseEntity taskAlreadyCreated(Exception e) {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}