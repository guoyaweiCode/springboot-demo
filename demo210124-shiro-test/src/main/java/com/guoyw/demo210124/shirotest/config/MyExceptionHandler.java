package com.guoyw.demo210124.shirotest.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @className: MyExceptionHandler
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/5
 **/

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

  @ExceptionHandler(AuthorizationException.class)
  public  String shiroHandle(){
    log.info("--> 您没有权限");
    return "您没有权限";
  }
}
