package com.guoyw.demo210107.shiro_example.shiro;

import com.guoyw.demo210107.shiro_example.entity.PermissionEntity;
import com.guoyw.demo210107.shiro_example.entity.RoleEntity;
import com.guoyw.demo210107.shiro_example.entity.UserEntity;
import com.guoyw.demo210107.shiro_example.service.AuthService;
import com.guoyw.demo210107.shiro_example.service.UserService;
import com.guoyw.demo210107.shiro_example.vo.UserAuthVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: AccountRealm
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/9
 **/

@Slf4j
public class AccountRealm extends AuthorizingRealm {

  @Autowired
  private UserService userService;

  // 认证
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    log.info("--> 进入 【AccountRealm.AuthenticationInfo】认证");
    UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
    // 获取用户输入的 用户名
    String username = (String) usernamePasswordToken.getPrincipal();
    //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法

    UserEntity userEntity = userService.getUserByUsernameOrEmail(username);
    // 判断用户是否存在
    if(userEntity == null){
      throw new UnknownAccountException();
    }
    // 判断用户是否锁定
    if(!userEntity.isEnabled()) {
      throw new LockedAccountException();
    }

    SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userEntity, userEntity.getPassword(),"accountRealm");
    log.info("--> 退出 【AccountRealm.AuthenticationInfo】simpleAuthenticationInfo："+simpleAuthenticationInfo.toString());
    return simpleAuthenticationInfo;
  }

  // 授权
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    log.info("--> 进入 【AccountRealm.AuthorizationInfo】授权");

     //    下面两种方式 是一样的
     //    UserEntity user = (UserEntity) principals.asList().get(0);
    UserEntity user = (UserEntity) SecurityUtils.getSubject().getPrincipal();
    log.info("--> UserEntity："+user.toString());

    // 获取角色
    List<String> roles = userService.getRolesByUserId(user.getUserId());
    log.info("--> roles："+roles.toString());

    // 获取权限
    List<String> permissions = userService.getPermissionByRoleIds(roles);
    log.info("--> permissions："+roles.toString());


    // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
    simpleAuthorizationInfo.addRoles(roles);
    simpleAuthorizationInfo.addStringPermissions(permissions);

    return simpleAuthorizationInfo;

  }


}
