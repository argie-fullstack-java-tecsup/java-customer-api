package com.api_tarea.exception;

import com.api_tarea.customer.errors.CustomerActiveDeletionNotAllowedException;
import com.api_tarea.customer.errors.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleCustomerNotFound(CustomerNotFoundException ex) {
    ErrorResponse error = new ErrorResponse(
        404,
        ex.getMessage(),
        LocalDateTime.now(),
        null);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(CustomerActiveDeletionNotAllowedException.class)
  public ResponseEntity<ErrorResponse> handleCustomerDeletionNotAllowed(CustomerActiveDeletionNotAllowedException ex) {
    ErrorResponse error = new ErrorResponse(
        409,
        ex.getMessage(),
        LocalDateTime.now(),
        null);
    return new ResponseEntity<>(error, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors()
        .forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));

    ErrorResponse error = new ErrorResponse(
        400,
        "Error de validacion",
        LocalDateTime.now(),
        errors);
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
