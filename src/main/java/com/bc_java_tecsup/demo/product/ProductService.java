package com.bc_java_tecsup.demo.product;

import com.bc_java_tecsup.demo.notification.contracts.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// LÓGICA DE NEGOCIO
@Service
public class ProductService {
  private final List<Product> products = new ArrayList<>();

  private final NotificationService notificationService;

  public ProductService(
      @Qualifier("emailNotificationService")
      NotificationService notifier
  ) {
    this.notificationService = notifier;
  }


  public List<Product> findAll() {
    return products;
  }

  public Product findById(Long id) {
    return products.stream().filter(
        p -> p.getId().equals(id)).findFirst().orElse(null);
  }

  public void create(Product product) {
    products.add(product);
  }

  public void delete(Long id) {
    products.removeIf(p -> p.getId().equals(id));
  }
}
