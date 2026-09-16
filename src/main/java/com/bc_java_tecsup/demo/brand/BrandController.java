package com.bc_java_tecsup.demo.brand;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {

  private final BrandService brandService;

  public BrandController(BrandService brandService) {
    this.brandService = brandService;
  }
}
