package com.bc_java_tecsup.api_tarea.customer.errors;

public class CustomerNotFoundException extends RuntimeException {
  public CustomerNotFoundException(String message) {
    super(message);
  }
}
