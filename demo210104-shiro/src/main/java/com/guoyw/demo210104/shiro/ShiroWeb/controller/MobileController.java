package com.guoyw.demo210104.shiro.ShiroWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: MobileController
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/5
 **/

@Slf4j
@RestController
@RequestMapping("/mobile")
public class MobileController {

  @RequestMapping("/query")
  private String query(){
    log.info("mobile 被请求了！！");
    return "mobile 被请求了！！";
  }
}
