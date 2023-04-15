package com.demo.consumer.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
@RequiredArgsConstructor
public class ProducerModule {

  private final ApplicationConfiguration applicationConfiguration;

  @Bean
  public RestTemplate producerRestTemplate(UriTemplateHandler producerUriTemplateHandler) {
    RestTemplate demoRestTemplate = new RestTemplate();
    demoRestTemplate.setUriTemplateHandler(producerUriTemplateHandler);

    return demoRestTemplate;
  }

  @Bean
  public UriTemplateHandler producerUriTemplateHandler() {
    return new DefaultUriBuilderFactory(applicationConfiguration.getProducer().getUrl());
  }
}
