package com.bc_java_tecsup.api_tarea.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

  private final List<Customer> customers = new ArrayList<>();

  public List<Customer> getAll() {
    return customers;
  }

  public Customer getById(Long id) {
    return customers.stream().filter(
        c -> c.getId().equals(id)).findFirst().orElse(null);
  }

  public void create(Customer customer) {
    customers.add(customer);
  }

  public void delete(Long id) {
    customers.removeIf(c -> c.getId().equals(id));
  }
}
