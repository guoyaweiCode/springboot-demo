package com.guoyw.demo210124.shirotest.config;

import com.guoyw.demo210124.shirotest.entity.UserEntity;
import com.guoyw.demo210124.shirotest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @className: MyRealm
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/24
 **/

@Slf4j
@Component
public class MyRealm extends AuthorizingRealm {

  private final Logger logger = LoggerFactory.getLogger(MyRealm.class);

  @Autowired
  UserService userService;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    logger.info("MyRealm.doGetAuthorizationInfo");
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

    // 设置角色和权限
    UserEntity user = (UserEntity) principalCollection.asList().get(0);
    simpleAuthorizationInfo.addRoles(user.getRoles());
    simpleAuthorizationInfo.addStringPermissions(user.getPermissions());

    return simpleAuthorizationInfo;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    logger.info("MyRealm.doGetAuthenticationInfo");
 // 获取当前用户
    UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
    String username = userToken.getUsername();
    // 获取数据库中的用户，来跟当前用户进行对比，认证。
    UserEntity userEntity = userService.getUserByUsername(username);
    if(userEntity == null){
      return  null;
    }

    SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userEntity,userEntity.getPassword(),"myRealm");
    return simpleAuthenticationInfo;
  }
}
