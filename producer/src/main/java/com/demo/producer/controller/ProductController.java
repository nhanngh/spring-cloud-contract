package com.demo.producer.controller;

import com.demo.producer.model.dto.ProductDTO;
import com.demo.producer.services.ProductService;
import com.demo.producer.services.ProductServiceFake;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
  private final ProductServiceFake productServiceFake;
  private final ProductService productService;

  @GetMapping("product/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProductDTO findProductById(@PathVariable Integer id) {
    return productServiceFake.findProductById(id);
  }

  @GetMapping("product/db/{id}")
  public ProductDTO findProductInDBById(@PathVariable Integer id) {
    return productService.findProductById(id);
  }
}
