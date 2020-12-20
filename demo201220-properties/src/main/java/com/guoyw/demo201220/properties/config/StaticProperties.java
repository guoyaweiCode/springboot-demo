package com.guoyw.demo201220.properties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: guoyw
 * @create: 2020-12-20 22:54
 **/

@Data
@Component
@ConfigurationProperties(prefix = "demo.book")
public class StaticProperties {

  public static String name;

  public static Integer price;

  public static List<String> authors;

  public  Details details;

  @Data
  public static class Details {

    private static String firstDate;

    private static String publicationDate;
  }
}
