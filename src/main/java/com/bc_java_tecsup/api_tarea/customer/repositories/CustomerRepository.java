package com.bc_java_tecsup.api_tarea.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bc_java_tecsup.api_tarea.customer.entities.Customer;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
}
