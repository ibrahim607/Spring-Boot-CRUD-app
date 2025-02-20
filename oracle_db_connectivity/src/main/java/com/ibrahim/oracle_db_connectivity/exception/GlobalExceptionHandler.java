package com.ibrahim.oracle_db_connectivity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFound(UserNotFoundException ex) {
        return buildErrorResponse(ex.getMessage(), ex.getErrorCode(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<Map<String,String >> handleUserAlreadyExists(UserAlreadyExists ex){
        return buildErrorResponse(ex.getMessage(), ex.getErrorCode(), HttpStatus.CONFLICT);
    }

    private ResponseEntity<Map<String, String>> buildErrorResponse(String message, String errorCode, HttpStatus status) {
        Map<String,String > errorResponse = new HashMap<>();
        errorResponse.put("Error code" , errorCode);
        errorResponse.put("Message" , message);
        return new ResponseEntity<>(errorResponse,status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage()); // Maps field names to messages
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
