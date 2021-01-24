package com.guoyw.demo210104.shiro.ShiroWeb.config;

import com.guoyw.demo210104.shiro.ShiroWeb.entity.UserEntity;
import com.guoyw.demo210104.shiro.ShiroWeb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @className: MyRealm
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/4
 **/

@Slf4j
//@Configuration
public class MobileRealm extends AuthorizingRealm {

  @Autowired
  private UserService userService;

  // 授权
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    log.info("进入 MyRealm >> 授权");
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

    // 设置角色和权限
    UserEntity user = (UserEntity) principalCollection.asList().get(0);
    simpleAuthorizationInfo.addRoles(user.getRoles());
    simpleAuthorizationInfo.addStringPermissions(user.getPermissions());

    return simpleAuthorizationInfo;
  }

  // r认证
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    log.info("进入 MyRealm >> 认证");

    // 获取当前用户
    UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
    String username = userToken.getUsername();
    // 获取数据库中的用户，来跟当前用户进行对比，认证。
    UserEntity userEntity = userService.getUserByMobile(username);
    if(userEntity == null){
      return  null;
    }

    SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userEntity,userEntity.getPassword(),"myRealm");
    return simpleAuthenticationInfo;
  }
}
