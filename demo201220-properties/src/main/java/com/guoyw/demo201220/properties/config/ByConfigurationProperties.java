package com.guoyw.demo201220.properties.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Component
@ConfigurationProperties(prefix = "demo.book")
public class ByConfigurationProperties {

  private String name;

  private Integer price;

  private List<String> authors;

  private Details details;

  @Data
  public static class Details {

    private String firstDate;

    private String publicationDate;
  }
}
