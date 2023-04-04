package com.demo.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class ProductController {

  private RestTemplate restTemplate;

  @GetMapping("/product-name/{id}")
  public String getProductName(@PathVariable Long id) {
    restTemplate = new RestTemplate();
    ResponseEntity<Product> productResponseEntity = restTemplate.exchange(
        "http://localhost:8081/product/{productId}", HttpMethod.GET, null, Product.class, id);
    return productResponseEntity.getBody().getName();
  }

  @GetMapping("/product/customer/{id}")
  public String getCustomerName(@PathVariable Long id) {
    restTemplate = new RestTemplate();
    ResponseEntity<String> productResponseEntity = restTemplate.exchange(
        "http://localhost:8081/customer/{customerId}", HttpMethod.GET, null, String.class, id);
    return productResponseEntity.getBody();
  }
}
