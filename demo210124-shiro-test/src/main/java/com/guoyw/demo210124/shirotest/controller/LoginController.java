package com.guoyw.demo210124.shirotest.controller;

import com.guoyw.demo210124.shirotest.entity.UserEntity;
import com.guoyw.demo210124.shirotest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: LoginController
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/4
 **/

@Slf4j
@RestController
@RequestMapping("/index")
public class LoginController {

  @Autowired
  private UserService userService;

  @RequestMapping("/login")
  public Object login(UserEntity userEntity){
    Map<String, String> result = new HashedMap();

    Subject subject = SecurityUtils.getSubject();
    if(!subject.isAuthenticated()){
      UsernamePasswordToken token = new UsernamePasswordToken(userEntity.getUsername(), userEntity.getPassword());
      try {
        subject.login(token);
        // todo 设置session
        UserEntity user = (UserEntity) subject.getPrincipal();
        subject.getSession().setAttribute("user",user);
        result.put("code","200");
      }catch (UnknownAccountException uae){
        log.info("没有用户名为 " + token.getPrincipal());
        result.put("errMsg","用户名不存在！！");
      }catch (IncorrectCredentialsException ice){
        log.info("帐户密码 " + token.getPrincipal() + " 不正确!");
        result.put("errMsg","密码错误！！");
      }catch (LockedAccountException lae){
        log.info("用户名帐户 " + token.getPrincipal() + " 锁住了.  " +
            "请与您的管理员联系以将其解锁.");
        result.put("errMsg","用户已锁定，请与您的管理员联系以将其解锁！！");
      }
      //在此处捕获更多异常（也许是针对您的应用程序的自定义异常？
      //更多异常 see：http://shiro.apache.org/
      catch (AuthenticationException ae) {
        //意外情况？错误
        log.info("登录失败！！");
        result.put("errMsg","登录失败！！");
      }
    }else {
      result.put("code","201");
    }
    return result;
  }

  @RequestMapping("/checkLogin")
  public Map<String,String> checkLogin(){
    HashMap<String, String> result = new HashMap<>();

    Subject subject = SecurityUtils.getSubject();
    if(subject.isAuthenticated()){
      result.put("code","300");
      return  result;
    }
    result.put("code","301");
    return  result;
  }

  @RequestMapping("/logout")
  public void logout(){
    Subject subject = SecurityUtils.getSubject();
    subject.logout();
  }

}
