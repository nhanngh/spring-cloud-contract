package com.demo.producer.controller;

import com.demo.producer.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping(value = "customer/{id}")
  public String findCustomerNameById(@PathVariable Integer id) {
    return customerService.findCustomerNameById(id);
  }
}
