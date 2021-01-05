package com.guoyw.demo210104.shiro.QuickStart;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @className: QuickStart
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/4
 **/

public class QuickStart {

  private static final transient Logger log = LoggerFactory.getLogger(QuickStart.class);

  public static void main(String[] args){

    //  获取管理器
    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
    SecurityManager securityManager = factory.getInstance();
    SecurityUtils.setSecurityManager(securityManager);

    // 获取当前登录用户
    Subject currentSubject = SecurityUtils.getSubject();
   // 获取当前登录用户session
    Session session = currentSubject.getSession();
    session.setAttribute("someKey","aValue");


    String value = (String) session.getAttribute("someKey");
    if(value.equals("aValue")){
      log.info("检索正确的值! [" + value + "]");
    }

    // 登录
    if(!currentSubject.isAuthenticated()){
      UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
      token.setRememberMe(true);
      try {
        currentSubject.login(token);
      }catch (UnknownAccountException uae){
        log.info("没有用户名为 " + token.getPrincipal());
      }catch (IncorrectCredentialsException ice){
        log.info("帐户密码 " + token.getPrincipal() + " 不正确!");
      }catch (LockedAccountException lae){
        log.info("用户名帐户 " + token.getPrincipal() + " 锁住了.  " +
            "请与您的管理员联系以将其解锁.");
      }
      //在此处捕获更多异常（也许是针对您的应用程序的自定义异常？
      //更多异常 see：http://shiro.apache.org/
      catch (AuthenticationException ae) {
        //意外情况？错误
      }


    }

    // 打印当前用户是谁
    log.info("用户 [" + currentSubject.getPrincipal() + "] 登录成功.");

    //验证角色
    if(currentSubject.hasRole("schwartz")){
      log.info("你拥有 Schwartz 角色!");
    }else {
      log.info("你好, 您没有角色.");
    }

    //验证权限(不是实例级)
    if(currentSubject.isPermitted("lightsaber:wield")){
      log.info("您可以使用 lightsaber.");
    }else {
      log.info("对不起, 您没有 lightsaber权限.");
    }

    ////验证权限(实例级)
    if (currentSubject.isPermitted("winnebago:drive:eagle5")) {
      log.info("您被允许 'drive' 和 'eagle5'.  " +
          "玩得开心!");
    } else {
      log.info("Sorry, 您没有 'eagle5' 权限!");
    }

    //退出登录
    currentSubject.logout();
  }


}
