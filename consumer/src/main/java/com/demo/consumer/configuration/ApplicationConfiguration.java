package com.demo.consumer.configuration;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app")
@Validated
public class ApplicationConfiguration {

  @NotNull
  @Valid
  private final Producer producer;

  @Getter
  @RequiredArgsConstructor
  public static class Producer {
    @NotBlank
    private final String url;
  }
}
