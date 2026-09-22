package com.api_tarea.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_tarea.customer.entities.Customer;
// Conecta el servicio con la DB
public interface CustomerRepository
  // Extiende JpaRepository y estos ejecutan el SQL
    extends JpaRepository<Customer, Long> {
}
