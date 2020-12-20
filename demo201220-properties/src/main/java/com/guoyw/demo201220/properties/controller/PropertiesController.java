package com.guoyw.demo201220.properties.controller;

import com.guoyw.demo201220.properties.config.ByConfigurationProperties;
import com.guoyw.demo201220.properties.config.ByValueProperties;
import com.guoyw.demo201220.properties.config.StaticProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/properties")
public class PropertiesController {

  @Autowired
  Environment environment;

  @Autowired
  ByValueProperties byValueProperties;
  @Autowired
  ByConfigurationProperties byConfigurationProperties;
  @Autowired
  StaticProperties staticProperties;

  @GetMapping({"/environmentProperties"})
  public String environmentProperties() {
    return "book name: " + environment.getProperty("demo.book.name")
        + " and price: " + environment.getProperty("demo.book.price") +
        " and details.firstDate: " + environment.getProperty("demo.book.details.firstDate") +
        " and details.publicationDate: " + environment.getProperty("demo.book.details.publicationDate");
  }

  @GetMapping({"/byValueProperties"})
  public String byValueProperties() {
    return "book name: " + byValueProperties.getName() + " and price: " + byValueProperties.getPrice();
//        + " and details.firstDate: " + byValueProperties.getDetails().getFirstDdate() +
//        " and details.publicationDate: " + byValueProperties.getDetails().getPublicationDate();
  }

  @GetMapping({"/byConfigurationProperties"})
  public String byConfigurationProperties() {

    String firstDate = byConfigurationProperties.getDetails() != null ? byConfigurationProperties.getDetails().getFirstDate() : " null ";
    String publicationDate = byConfigurationProperties.getDetails() != null ? byConfigurationProperties.getDetails().getPublicationDate() : " null ";

    return "book name: " + byConfigurationProperties.getName() + " and price: " +
        byConfigurationProperties.getPrice() + " and authors: " +
        byConfigurationProperties.getAuthors().toString() +
        " and details.firstDate: " + firstDate +
        " and details.publicationDate: " + publicationDate;
  }

  @GetMapping({"/StaticProperties"})
  public String StaticProperties() {


    return "book name: " + byConfigurationProperties.getName() + " and price: " +
        byConfigurationProperties.getPrice() + " and authors: " +
        byConfigurationProperties.getAuthors().toString();
  }
}
