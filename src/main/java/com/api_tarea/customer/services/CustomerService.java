package com.api_tarea.customer.services;

import org.springframework.stereotype.Service;

import com.api_tarea.customer.entities.Customer;
import com.api_tarea.customer.repositories.CustomerRepository;

import com.api_tarea.customer.errors.CustomerActiveDeletionNotAllowedException;
import com.api_tarea.customer.errors.CustomerNotFoundException;

import java.util.List;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> getAll() {
    return customerRepository.findAll();
  }

  public Customer getById(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(() -> new CustomerNotFoundException(
            "Cliente con id " + id + " no encontrado en sistema."));
  }

  public void create(Customer customer) {
    customerRepository.save(customer);
  }

  public void delete(Long id) {
    Customer customer = getById(id);
    // solo borrar si el cliente esta inactivo (customer.getActive() == false)
    System.out.println("Cliente id " + id + " activo: " + customer.getActive());
    if (Boolean.TRUE.equals(customer.getActive())) {
      throw new CustomerActiveDeletionNotAllowedException(
          "El cliente con id " + id + " esta activo y no se permite eliminar.");
    }
    customerRepository.deleteById(id);
  }
}
