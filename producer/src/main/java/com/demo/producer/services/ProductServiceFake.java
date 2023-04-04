package com.demo.producer.services;

import com.demo.producer.model.dto.ProductDTO;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductServiceFake {

  private final Map<Integer, ProductDTO> productMapper;

  public ProductServiceFake() {
    // fake data of product to test
    this.productMapper = Map.of(1, new ProductDTO(1, "Macbook 2015", "OS mac os", 2000L),
        2, new ProductDTO(2, "Dell", "OS windows", 1500L));
  }

  public ProductDTO findProductById(Integer productId) {
    var product = productMapper.get(productId);
    if (product == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found.");
    }

    return product;
  }
}
