package com.guoyw.dem210104.shiro.ShiroWeb.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: ShiroConfig
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/4
 **/

@Configuration
public class ShiroConfig {

  // 1、Realm 代表系统资源
  @Bean
  public Realm myRealm(){
    return new MyRealm();
  }

  // 2、SecurityManager 流程控制
  @Bean
  public DefaultWebSecurityManager mysSecurityManager(Realm myRealm){
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(myRealm);

    return securityManager;
  }

  // 3、 ShiroFilterFactoryBean 请求过滤器
  @Bean
  public ShiroFilterFactoryBean myShiroFilterFactoryBean(DefaultWebSecurityManager myShiroFilterFactoryBean){
    ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
    filterFactoryBean.setSecurityManager(myShiroFilterFactoryBean);

    // 配置路径过滤器
    Map<String, String> filterMap = new HashMap<>();
    // key 是ant路径，value配置shiro默认配置
    filterMap.put("/main/**", DefaultFilter.authc.toString());
    filterFactoryBean.setFilterChainDefinitionMap(filterMap);
    return filterFactoryBean;
  }

}
