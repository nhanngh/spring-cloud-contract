package com.demo.consumer;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
public class ProductController {

  private final RestTemplate producerRestTemplate;

  @GetMapping("/product-name/{id}")
  public String getProductName(@PathVariable Long id) {
    String endpoint = UriComponentsBuilder.fromUriString("/product/{id}").build().toString();
    Product product = producerRestTemplate.getForObject(endpoint, Product.class, id);

    if (Objects.isNull(product)) {
      throw new IllegalArgumentException("Product not found.");
    }

    return product.getName();
  }

  @GetMapping("/product/customer/{id}")
  public String getCustomerName(@PathVariable Long id) {
    String endpoint = UriComponentsBuilder.fromUriString("/customer/{id}").build().toString();
    String customerName = producerRestTemplate.getForObject(endpoint, String.class, id);

    if (customerName == null) {
      throw new IllegalArgumentException("Customer name not found.");
    }

    return customerName;
  }
}
