package com.demo.producer.services;

import com.demo.producer.model.dto.ProductDTO;
import com.demo.producer.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public ProductDTO findProductById(Integer productId) {
    var productEntity = productRepository.findById(productId).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

    return new ProductDTO(productEntity.getId(), productEntity.getName(),
        productEntity.getDescription(), productEntity.getPrice());
  }
}
