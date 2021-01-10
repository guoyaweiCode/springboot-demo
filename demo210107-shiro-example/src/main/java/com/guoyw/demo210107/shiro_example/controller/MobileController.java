package com.guoyw.demo210107.shiro_example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@Api(tags = "手机Controller")
public class MobileController {

  @ApiOperation("查看手机号")
  @RequestMapping("/query")
  @RequiresPermissions(value={"add","update"},logical = Logical.OR)

  private String query(){
    /*Subject subject = SecurityUtils.getSubject();
    if(!subject.isPermitted("mobile")){
      return  "error: query not permission !";
    }*/
    log.info("mobile 被请求了！！");
    return "mobile 被请求了！！";
  }
}
