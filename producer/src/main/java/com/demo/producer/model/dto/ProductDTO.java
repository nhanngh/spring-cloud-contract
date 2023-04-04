package com.demo.producer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProductDTO {
  private Integer id;
  private String name;
  private String description;
  private Long price;
}
