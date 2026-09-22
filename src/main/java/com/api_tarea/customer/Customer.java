package com.api_tarea.customer;

public class Customer {
  private Long id;
  private String name;
  private String lastname;
  private String document_number;
  private String email;
  private String address;
  private String ruc;
  private Boolean is_active;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getDocument_number() {
    return document_number;
  }

  public void setDocument_number(String document_number) {
    this.document_number = document_number;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public Boolean getIs_active() {
    return is_active;
  }

  public void setIs_active(Boolean is_active) {
    this.is_active = is_active;
  }
}

