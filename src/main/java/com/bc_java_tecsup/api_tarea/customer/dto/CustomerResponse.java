package com.bc_java_tecsup.api_tarea.customer.dto;

// DTO
// Data Transfer Object
public class CustomerResponse {

  private String name;
  private String lastname;
  private String email;

  public CustomerResponse() {
  }

  public CustomerResponse(String name, String lastname, String email) {
    this.name = name;
    this.lastname = lastname;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
