package com.guoyw.demo210104.shiro.ShiroWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: SalaryController
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/5
 **/

@Slf4j
@RestController
@RequestMapping("/salary")
public class SalaryController {

  @RequestMapping("/query")
  private void query(){
    log.info("salary 被请求了！！");
    return;
  }
}
