package com.guoyw.demo210107.shiro_example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@Api(tags = "工资controller")
public class SalaryController {

  @ApiOperation("查看工资")
  @RequiresPermissions("salary")
  @RequestMapping("/query")
  private String query(){
    /*Subject subject = SecurityUtils.getSubject();
    if(!subject.isPermitted("salary")){
      return  "error: query not permission !";
    }*/

    log.info("salary 被请求了！！");
    return "salary 被请求了！！";
  }
}
