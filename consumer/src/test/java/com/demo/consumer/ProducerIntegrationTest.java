package com.demo.consumer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureStubRunner(ids = {
    "com.demo:producer:0.0.1-SNAPSHOT:stubs:8080"}, stubsMode = StubsMode.LOCAL)
class ProducerIntegrationTest {

  @Test
  void get_product1() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Product> responseEntity = restTemplate.getForEntity(
        "http://localhost:8080/product/1", Product.class);
    assertTrue(responseEntity.hasBody());

    Product product = responseEntity.getBody();
    assertNotNull(product);
    assertAll(
        () -> assertEquals(1L, product.getId()),
        () -> assertEquals("Macbook 2015", product.getName()),
        () -> assertEquals("OS mac os", product.getDescription()),
        () -> assertEquals(2000L, product.getPrice())
    );
  }

  @Test
  void get_product2() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Product> responseEntity = restTemplate.getForEntity(
        "http://localhost:8080/product/2", Product.class);
    assertTrue(responseEntity.hasBody());

    Product product = responseEntity.getBody();
    assertAll(
        () -> assertEquals(2L, product.getId()),
        () -> assertEquals("Dell", product.getName()),
        () -> assertEquals("OS windows", product.getDescription()),
        () -> assertEquals(1500L, product.getPrice())
    );
  }

  @Test
  void get_product3() {
    RestTemplate restTemplate = new RestTemplate();
    var exception = assertThrows(HttpClientErrorException.class,
        () -> restTemplate.getForEntity("http://localhost:8080/product/3", Product.class));
    assertEquals(exception.getStatusText(), HttpStatus.NOT_FOUND.getReasonPhrase());
  }

  @Test
  void get_customer1() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(
        "http://localhost:8080/customer/1", String.class);
    assertTrue(responseEntity.hasBody());

    String customerName = responseEntity.getBody();
    assertEquals(customerName, "harry");
  }
}
