package com.guoyw.demo210107.shiro_example.controller;

import com.guoyw.demo210107.shiro_example.dto.LoginAccountDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HomeController
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/7
 **/

@RestController
@RequestMapping("/home")
public class HomeController {

  @RequestMapping("/loginAccount")
  public String loginAccount(LoginAccountDto loginAccountDto){
    // 支持 用户名+密码 或者 邮箱+密码

    return null;
  }

}
