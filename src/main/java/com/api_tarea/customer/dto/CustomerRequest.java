package com.api_tarea.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomerRequest {

  @NotBlank
  private String name;

  @NotBlank
  private String lastname;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  private String documentNumber;

  private String address;
  private String ruc;

  @NotNull
  private Boolean active;

  public CustomerRequest() {
  }

  public CustomerRequest(String name, String lastname, String email, String documentNumber,
                         String address, String ruc, Boolean active) {
    this.name = name;
    this.lastname = lastname;
    this.email = email;
    this.documentNumber = documentNumber;
    this.address = address;
    this.ruc = ruc;
    this.active = active;
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

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getRuc() {
    return ruc;
  }

  public void setRuc(String ruc) {
    this.ruc = ruc;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }
}
