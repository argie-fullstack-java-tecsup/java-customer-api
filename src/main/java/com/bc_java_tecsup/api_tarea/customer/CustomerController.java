package com.bc_java_tecsup.api_tarea.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/customers")
  public List<Customer> getAll() {
    return customerService.getAll();
  }

  @GetMapping("/customers/{id}")
  public Customer getById(@PathVariable Long id) {
    return customerService.getById(id);
  }

  @PostMapping("/customers")
  public Customer create(@RequestBody Customer customer) {
    customerService.create(customer);
    return customer;
  }

  @DeleteMapping("/customers/{id}")
  public void delete(@PathVariable Long id) {
    customerService.delete(id);
  }
}
