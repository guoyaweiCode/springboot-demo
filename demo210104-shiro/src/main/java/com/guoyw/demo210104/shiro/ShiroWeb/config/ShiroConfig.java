package com.guoyw.demo210104.shiro.ShiroWeb.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @className: ShiroConfig
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/4
 **/

@Slf4j
//@Configuration
public class ShiroConfig {

  /*@Bean
  public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
    return new LifecycleBeanPostProcessor();
  }

  @Bean
  public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
    DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//    advisorAutoProxyCreator.setProxyTargetClass(true);
//    advisorAutoProxyCreator.setUsePrefix(true);
    return advisorAutoProxyCreator;
  }

  // 1、Realm 代表系统资源
  @Bean
  public Realm realm(){
    return new MyRealm();
  }

  // 2、SecurityManager 流程控制
  @Bean
  public DefaultWebSecurityManager securityManager(Realm realm){
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(realm());

    return securityManager;
  }

  // 3、 ShiroFilterFactoryBean 请求过滤器
  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
    log.info("--> ShiroConfig.ShiroFilterFactoryBean 请求过滤器");
    ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
    filterFactoryBean.setSecurityManager(securityManager);
    // 设置登录页
    filterFactoryBean.setLoginUrl("/index.html");
    // 登录成功后要跳转的链接
    filterFactoryBean.setSuccessUrl("/main");
    //未授权界面;
    filterFactoryBean.setUnauthorizedUrl("/403");

    //自定义拦截器
    Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
    //    filtersMap.put("myAccessControlFilter", new MyAccessControlFilter());
    filterFactoryBean.setFilters(filtersMap);

    Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
    //我做的是无状态的，这里的东西实际上是用不到的，仅供参考
    //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
//    filterChainDefinitionMap.put("/logout", "logout");
//    filterChainDefinitionMap.put("/css/**","anon");
//    filterChainDefinitionMap.put("/js/**","anon");
//    filterChainDefinitionMap.put("/img/**","anon");
//    filterChainDefinitionMap.put("/font-awesome/**","anon");
//
//    //  filterChainDefinitionMap.put("/users", "anon");
//    filterChainDefinitionMap.put("/createPermission", "anon");
//    filterChainDefinitionMap.put("/**", "myAccessControlFilter");
//      filterChainDefinitionMap.put("/**", "authc");
    //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
    //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
    //自定义加载权限资源关系
//        List<Resources> resourcesList = resourcesService.queryAll();
//        for(Resources resources:resourcesList){
//
//            if (StringUtil.isNotEmpty(resources.getResurl())) {
//                String permission = "perms[" + resources.getResurl()+ "]";
//                filterChainDefinitionMap.put(resources.getResurl(),permission);
//            }
//        }
    filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return filterFactoryBean;
  }

  *//**
   *  开启shiro aop注解支持.
   *  使用代理方式;所以需要开启代码支持;
   * @param securityManager
   * @return
   *//*
  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
    return authorizationAttributeSourceAdvisor;
  }


  *//**
   * 下面几个类是网上搜来的解决方案
   * @return
   *//*

*//*  @Bean
  public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
    return new LifecycleBeanPostProcessor();
  }

  @Bean
  public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
    DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
    advisorAutoProxyCreator.setProxyTargetClass(true);
    return advisorAutoProxyCreator;
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
    return authorizationAttributeSourceAdvisor;
  }*//*
*/
}
