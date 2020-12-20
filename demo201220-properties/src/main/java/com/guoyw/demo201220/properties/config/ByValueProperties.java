package com.guoyw.demo201220.properties.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Data
@Component
public class ByValueProperties {

  @Value("${demo.book.name}")
  private String name;

  @Value("${demo.book.price}")
  private Integer price;

  // 注意 使用@Value 只支持 一个个指定
  //  @Value("${demo.book.authors}")
  //  private List<String> authors;

//  @Value("${demo.book.details}")
//  private Details details;
//
//
//  @Data
// public class Details{
//
//    private Data firstDdate;
//
//    private Data publicationDate;
//  }
}
