package com.guoyw.demo210104.shiro.ShiroWeb.config;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @className: MyExceptionHandler
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/5
 **/

@RestControllerAdvice
public class MyExceptionHandler {

  @ExceptionHandler(AuthorizationException.class)
  public  String shiroHandle(){
    return "您没有权限";
  }
}
