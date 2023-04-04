package com.demo.producer;

import com.demo.producer.controller.CustomerController;
import com.demo.producer.controller.ProductController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseClass {

  @Autowired
  ProductController productController;

  @Autowired
  CustomerController customerController;

  @BeforeEach
  public void setup() {
    RestAssuredMockMvc.standaloneSetup(productController, customerController);
  }
}
