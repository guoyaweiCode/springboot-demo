package com.guoyw.demo210104.shiro.ShiroWeb.controller;

import com.guoyw.demo210104.shiro.ShiroWeb.entity.UserEntity;
import com.guoyw.demo210104.shiro.ShiroWeb.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: MainController
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/5
 **/

@RestController
@RequestMapping("/main")
public class MainController {

  @Autowired
  private UserService userService;

  @RequestMapping("/getCurrentUser")
  public UserEntity getCurrentUser(){

    Subject subject = SecurityUtils.getSubject();
    if(subject.isAuthenticated()){
      UserEntity user = (UserEntity) subject.getSession().getAttribute("user");
      return user;
    }
    return null;
  }

}
