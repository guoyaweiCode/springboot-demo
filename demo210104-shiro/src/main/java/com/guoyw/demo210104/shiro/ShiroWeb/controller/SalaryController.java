package com.guoyw.demo210104.shiro.ShiroWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
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

  @RequiresPermissions("salary")
  @RequestMapping("/query")
//  @RequiresRoles({"admin"})
  private String query(){
    /*Subject subject = SecurityUtils.getSubject();
    if(!subject.isPermitted("salary")){
      return  "error: query not permission !";
    }*/

    log.info("salary 被请求了！！");
    return "salary 被请求了！！";
  }
}
