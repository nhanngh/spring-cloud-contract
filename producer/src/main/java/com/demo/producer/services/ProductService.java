package com.demo.producer.services;

import com.demo.producer.model.dto.ProductDTO;

public interface ProductService {

  ProductDTO findProductById(Integer productId);
}
