package com.bc_java_tecsup.demo.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// Etiqueta para hacer los requests HTTP
@RestController
// Clase controladora
public class ProductController {

  // variable donde voy a almacenar los productos
  // List<Product> products = new ArrayList<Product>(); // Esto se borró después de que hizo el @Service

  // Se reemplaza por este:
  private final ProductService productService;

  // Aca spring hace la DI
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  // Estos "endpoints" no funcionan sin un método
  @GetMapping("/products")
  // CUÁL ES EL ESTÁNDAR PARA NOMBRAR LOS ME-TODOS??
  public List<Product> findAll() {
    return productService.findAll();
  }

  @GetMapping("/products/{id}")
  public Product findById(@PathVariable Long id) {
    // TODO: PROFUNDIZAR EN LOS STREAMS (PROGRAMACIÓN FUNCIONAL)
    return productService.findById(id);
  }

  // Para crear se usa esta etiqueta
  @PostMapping("/products")
  // Por qué se tiene que volver formato Java si el contenido va a ser almacenado en la BBDD?
  public Product create(
      // Qué hace realmente este RequestBody?
      @RequestBody Product product
  ) {
    productService.create(product);
    return product;
  }

  @DeleteMapping
  public void delete(@PathVariable Long id) {
    productService.delete(id);

  }
}