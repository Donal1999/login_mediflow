package com.example.login_mediflow;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExecptionDetails>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ExecptionDetails> errors = new ArrayList<>();
        for(FieldError error : ex.getBindingResult().getFieldErrors()) {
            ExecptionDetails details = new ExecptionDetails(error.getField(),error.getDefaultMessage());
            errors.add(details);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
