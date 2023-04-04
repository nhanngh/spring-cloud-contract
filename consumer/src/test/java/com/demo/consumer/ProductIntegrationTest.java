package com.demo.consumer;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = {"com.demo:producer:+:stubs:8080"}, stubsMode = StubsMode.LOCAL)
class ProductIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void getProductName_success() throws Exception {
    this.mockMvc.perform(
            get("/product-name/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Macbook 2015")));
  }
}
