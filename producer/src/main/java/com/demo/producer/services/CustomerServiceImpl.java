package com.demo.producer.services;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private Map<Integer, String> customerData = Map.of(1, "harry", 2, "ron");

  @Override
  public String findCustomerNameById(Integer id) {
    var customerName = customerData.get(id);
    if (customerName == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.");
    }

    return customerName;
  }
}
