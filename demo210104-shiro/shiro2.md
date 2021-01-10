# Shiro

# SpringSecurity

authentication 认证  确定用户身份   用户名密码验证

authorization 授权  对用户访问系统资源的行为做控制。  后台接口访问， 前台页面元素，敏感数据

RBAC   role based access control

## 了解shiro

## Shiro QuickStart

```
Subject currentUser = SecurityUtils.getSubject(); 
Session session = currentUser.getSession();
//认证
currentUser.login(token);  //通过抛出的异常来判断用户登录结果
//授权
currentUser.hasRole
currentUser.isPermitted
currentUser.isAuthenticated()

currentUser.logout();

```

## ShiroWeb

基础框架搭建：  shiro配置三板斧

```
package com.tuling.shiroweb.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    //1 Realm  代表系统资源
    @Bean
    public Realm myRealm(){
        return new MyRealm();
    }
    //2 SecurityManager 流程控制
    @Bean
    public DefaultWebSecurityManager mySecurityManager(Realm myRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);

        return securityManager;
    }
    //3 ShiroFilterFactoryBean 请求过滤器
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager mySecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(mySecurityManager);

        return factoryBean;
    }
}
```

### 实现登录验证功能

​	1、创建自己的Realm对象，继承AuthorizingRealm。

​	实现父类的doGetAuthenticationInfo 认证方法。

​	2、配置路径过滤器

```
//配置路径过滤器
Map<String,String> filterMap = new HashMap<>();
//key是ant路径，支持**代表多级路径，*代表单级路径，？代表一个字符
filterMap.put("")

factoryBean.setFilterChainDefinitionMap(filterMap);
```

目前实现的功能：

1、已经可以正常判断用户名和密码。

2、两个资源路径需要登录才可以访问。 否则跳到了login.jsp

### 修复登录认证错误的访问情况

设置登录页、登录成功页、未经授权页

登出，有两种方式

一

```
@RequestMapping("/logout")
public void logout() {
    Subject currentUser = SecurityUtils.getSubject();
    currentUser.logout();
}
```

二、使用shiro提供的logout过滤器

```
filterMap.put("/common/logout","logout");
```



### 实现授权功能

目标：

1、控制主页上按钮的访问权限

​	currentUser.getPricipal()   来自于  MyRealm中doGetAuthenticationInfo认证方法返回的SimpleAuthenticationInfo对象的第一个属性。

2、控制后台资源路径的访问权限

​	方法1、硬编码的方式，自行判断权限。

​	方法2、使用shiro提供的perms过滤器，集中配置权限信息。 

​		错误补充机制：没有权限就会进入ShiroFilterFactoryBean中配置的UnauthorizedUrl

​	方法3、使用shiro提供的注解，实现方法级别的权限控制。

​		@RequiresAuthentication  需要完成用户登录

​		@RequiresGuest  未登录用户可以访问，登录用就不能访问。

​		@RequiresPermissions 需要有对应资源权限

​		@RequiresRoles  需要有对应的角色

​		@RequiresUser  需要完成用户登录并且完成了记住我功能。

​	错误补充机制：没有权限就会抛出异常。



## 密码加密

shiro会获得一个CredentialsMatcher对象，来对密码进行比对。

想要用MD5方式进行加密：

​	Md5CredentialsMatcher已经过期， 要使用HashedCredentialsMatcher并设定算法名。

HashedCredentialsMatcher 

​	String hashAlgorithm, 对应Hash接口的实现类。  MD5

​	int hashIterations Hash迭代次数。

​	boolean hashSalted  已过时，不用设置

​	boolean storedCredentialsHexEncoded  设置默认的true

加盐加密：

​	需要在认证返回的认证信息SimpleAuthenticationInfo中，指定需要加的盐salt。这样算出来的密文才可以和数据库中的密文进行比对。



## 多Realm认证

要实现用户名和手机号都可以登录的功能。

org.apache.shiro.authc.pam.ModularRealmAuthenticator

```
protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
    assertRealmsConfigured();
    Collection<Realm> realms = getRealms();
    if (realms.size() == 1) {
        return doSingleRealmAuthentication(realms.iterator().next(), authenticationToken);
    } else {
        return doMultiRealmAuthentication(realms, authenticationToken);
    }
}
```

可以定义多个Realm完成不同的认证功能。

我们通过增加一个MobileRealm，就实现了按照手机号也可以登录的功能。

多Realm的认证策略

  AuthenticationStrategy接口 有三个实现类

​		AllSuccessfulStrategy   需要所有Realm认证成功，才能最终认证成功。

​		AtLeastOneSuccessfulStrategy  至少有一个Realm认证成功，才能最终认证成功。

​		FirstSuccessfulStrategy    第一个Realm认证成功后即返回认证成功，不再进行后面的Realm认证。





## 记住我 功能

回顾记住我的功能。  

​	token.setRememberMe(true);

记住我 功能对应了 默认的user过滤器。

怎么设置记住我的时长，以及记到哪里。

 securityManager.setRememberMeManager(rememberMeManager); 管理RememberMe的数据

## 会话管理

 securityManager.setSessionManager(sessionManager); 实现会话管理

## 认证缓存

```
MemoryConstrainedCacheManager cacheManager = new MemoryConstrainedCacheManager();
securityManager.setCacheManager(cacheManager);
```

记住我，会话管理以及认证缓存，都可以通过扩展对应的manager接口的方式，实现自己的灵活扩展，比如将信息共享到redis。



## Realm类型