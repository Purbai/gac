package com.gac.codingGame.common;

import com.gac.codingGame.common.exceptions.BadRequestException;
import com.gac.codingGame.common.exceptions.NotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<String>(ex.getMessage(), ex.getStatusCode());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ValidationErrors> handleBadRequestException( BadRequestException ex){
        return new ResponseEntity<>(ex.getErrors(), ex.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrors> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ValidationErrors validationErrors = new ValidationErrors();
        ex.getBindingResult().getFieldErrors()
                .forEach(err -> {
                    validationErrors.add(err.getField(), err.getDefaultMessage());
                    // Log for debugging
                    LoggerFactory.getLogger(GlobalExceptionHandler.class)
                            .error("Validation failed for field: {} - reason: {}", err.getField(), err.getDefaultMessage());
                });

        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }
}
