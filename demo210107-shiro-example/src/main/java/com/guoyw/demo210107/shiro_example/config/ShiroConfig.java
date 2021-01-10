package com.guoyw.demo210107.shiro_example.config;

import com.guoyw.demo210107.shiro_example.filter.MyAccessControlFilter;
import com.guoyw.demo210107.shiro_example.shiro.AccountRealm;
import com.guoyw.demo210107.shiro_example.shiro.MyModularRealmAuthenticator;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: ShiroConfig
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/9
 **/

@Slf4j
@Configuration
public class ShiroConfig {

  // SecurityManager 流程控制
  @Bean
  public DefaultWebSecurityManager securityManager() {
      log.info("--> 进入 【Shiro.securityManager】流程控制器");
      DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setAuthenticator(customizedModularRealmAuthenticator());

    List<Realm> realms=new ArrayList<>();
    realms.add(accountRealm());
    securityManager.setRealms(realms);
    return securityManager;
  }


  // 请求拦截器
  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
    log.info("--> 进入【ShiroConfig.shiroFilterFactoryBean】请求拦截器  ");
    ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
    // 设置securityManager （必须）
    filterFactoryBean.setSecurityManager(securityManager);

    // 设置登录页 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
    filterFactoryBean.setLoginUrl("/home/loginAccount");

    // 自定义拦截器
    Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
    filtersMap.put("myAccessControlFilter", new MyAccessControlFilter());
    filterFactoryBean.setFilters(filtersMap);

    //拦截器.
    Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
    //我做的是无状态的，这里的东西实际上是用不到的，仅供参考
    //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
    /*
    filterChainDefinitionMap.put("/logout", "logout");
    filterChainDefinitionMap.put("/css/**","anon");
    filterChainDefinitionMap.put("/js/**","anon");
    filterChainDefinitionMap.put("/img/**","anon");
    filterChainDefinitionMap.put("/font-awesome/**","anon");
    */

    //  filterChainDefinitionMap.put("/users", "anon");


    filterChainDefinitionMap.put("/user/login","anon");
    //Swagger的所有请求的资源和请求的地址都不需要拦截
    filterChainDefinitionMap.put("/swagger/**","anon");
    filterChainDefinitionMap.put("/v2/api-docs","anon");
    filterChainDefinitionMap.put("/swagger-ui.html","anon");
    filterChainDefinitionMap.put("/swagger-resources/**","anon");
    filterChainDefinitionMap.put("/webjars/**","anon");
    filterChainDefinitionMap.put("/favicon.ico","anon");
    filterChainDefinitionMap.put("/captcha.jpg","anon");
    filterChainDefinitionMap.put("/csrf","anon");
    filterChainDefinitionMap.put("/**", "myAccessControlFilter");
    //   filterChainDefinitionMap.put("/**", "authc");

    filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return filterFactoryBean;
  }


  /*
   * 下面两个是为了使生效
   * @RequiresRoles(value={"admin","user"},logical = Logical.OR)
   * @RequiresPermissions(value={"add","update"},logical = Logical.OR)
   */
  @Bean
  public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
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
  }

  @Bean
  public AccountRealm accountRealm(){
    AccountRealm accountRealm = new AccountRealm();
    //我自己实现的加密判断，这里被备注起来，仅供参考
    //     myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
    return accountRealm;
  }

  /**
   * 自定义的Realm管理，主要针对多realm
   * */
  @Bean
  public MyModularRealmAuthenticator customizedModularRealmAuthenticator(){
    MyModularRealmAuthenticator customizedModularRealmAuthenticator=new MyModularRealmAuthenticator();
    //设置realm判断条件
    customizedModularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());

    return customizedModularRealmAuthenticator;
  }

  /**
   * 系统自带的Realm管理，主要针对多realm
   * */
  @Bean
  public ModularRealmAuthenticator modularRealmAuthenticator(){
    ModularRealmAuthenticator modularRealmAuthenticator=new ModularRealmAuthenticator();
    modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
    return modularRealmAuthenticator;
  }
}
