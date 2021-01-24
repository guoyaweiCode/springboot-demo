package com.guoyw.demo210124.shirotest.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: SalaryController
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/24
 **/

@RestController
@RequestMapping("/salary")
public class SalaryController {

  @RequiresPermissions("salary")
  @GetMapping("/query")
  public String query(){
    return "salary";
  }

}
