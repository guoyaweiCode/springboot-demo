package com.guoyw.demo210107.shiro_example.controller;

import com.guoyw.demo210107.shiro_example.dto.LoginAccountDto;
import com.guoyw.demo210107.shiro_example.service.AuthService;
import com.guoyw.demo210107.shiro_example.vo.UserAuthVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HomeController
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/7
 **/

@Slf4j
@RestController
@RequestMapping("/home")
@Api(tags = "通用接口",description = "HomeController")
public class HomeController {

  @Autowired
  private AuthService authService;

  @PostMapping("/loginAccount")
  @ApiOperation("账号登录")
  public UserAuthVo loginAccount(LoginAccountDto loginAccountDto){
    // 支持 用户名+密码 或者 邮箱+密码
    UserAuthVo userAuthVo = authService.loginAccount(loginAccountDto);
    if(userAuthVo != null){
      log.info("登录成功！！");

    }else {
      log.info("登录失败！！");
    }

    return userAuthVo;
  }

}
