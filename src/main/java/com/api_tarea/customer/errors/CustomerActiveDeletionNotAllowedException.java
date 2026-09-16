package com.api_tarea.customer.errors;

public class CustomerActiveDeletionNotAllowedException extends RuntimeException {
  public CustomerActiveDeletionNotAllowedException(String message) {
    super(message);
  }
}
