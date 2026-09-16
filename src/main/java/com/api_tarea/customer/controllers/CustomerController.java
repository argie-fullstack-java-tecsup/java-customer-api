package com.api_tarea.customer.controllers;

import com.api_tarea.customer.dto.CustomerRequest;
import com.api_tarea.customer.dto.CustomerResponse;
import com.api_tarea.customer.entities.Customer;
import com.api_tarea.customer.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customers", description = "Operaciones del API de clientes")

public class CustomerController {
  // Atributos
  private final CustomerService customerService;

  // Ahi Spring hace la DI
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @Operation(summary = "Lista todos los clientes")
  @GetMapping
  public List<Customer> getAll() {
    return customerService.getAll();
  }

  @Operation(summary = "Busca un cliente por su id")
  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> getById(@PathVariable Long id) {
    Customer customer = customerService.getById(id);
    CustomerResponse response = new CustomerResponse(
        customer.getName(), customer.getLastname(), customer.getEmail());
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Operation(summary = "Crea un nuevo cliente")
  @PostMapping
  public ResponseEntity<CustomerResponse> create(
      @Valid @RequestBody CustomerRequest request) {
    Customer customer = new Customer();
    customer.setName(request.getName());
    customer.setLastname(request.getLastname());
    customer.setEmail(request.getEmail());
    customer.setDocumentNumber(request.getDocumentNumber());
    customer.setAddress(request.getAddress());
    customer.setRuc(request.getRuc());
    customer.setActive(request.getActive());

    customerService.create(customer);

    CustomerResponse response = new CustomerResponse(
        customer.getName(), customer.getLastname(), customer.getEmail());
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @Operation(summary = "Elimina un cliente (falla 409 si esta activo)")
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    customerService.delete(id);
  }
}
