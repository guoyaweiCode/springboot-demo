package com.guoyw.demo210124.shirotest.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: ShiroConfig
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/24
 **/

@Configuration
public class ShiroConfig {

//  @Bean
//  public Realm myRealm(){
//    return new MyRealm();
//  }

  @Bean
  public DefaultWebSecurityManager getSecurityManager(Realm myRealm){
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(myRealm);
    return securityManager;
  }


  @Bean
  public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
    ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
    filterFactoryBean.setSecurityManager(securityManager);
    return filterFactoryBean;
  }

}
