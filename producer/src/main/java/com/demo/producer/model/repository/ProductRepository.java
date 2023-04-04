package com.demo.producer.model.repository;

import com.demo.producer.model.entity.ProductEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

  Optional<ProductEntity> findById(Integer id);

  boolean existsByName(String name);

  Optional<ProductEntity> findByName(String name);
}