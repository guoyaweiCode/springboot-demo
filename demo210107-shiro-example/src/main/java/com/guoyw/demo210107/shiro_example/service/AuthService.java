package com.guoyw.demo210107.shiro_example.service;

import com.guoyw.demo210107.shiro_example.dto.LoginAccountDto;
import com.guoyw.demo210107.shiro_example.entity.*;
import com.guoyw.demo210107.shiro_example.utils.DBTestData;
import com.guoyw.demo210107.shiro_example.vo.UserAuthVo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: AuthService
 * @description: 安全认证service
 * @author: guoyw
 * @date: 2021/1/7
 **/

@Service
public class AuthService {

  public UserAuthVo loginAccount(LoginAccountDto loginAccountDto) {
    UserAuthVo result = new UserAuthVo();

    UserEntity userEntity = DBTestData.getAllUsers().stream()
        .filter(user -> user.getUsername().equals(loginAccountDto.getUsername()) || user.getEmail().equals(loginAccountDto.getUsername()))
        .findFirst()
        .orElseThrow(()->new RuntimeException("用户不存在"));

    UserToRoleEntity userToRoleEntity = DBTestData.getAllUserToRoles().stream()
        .filter(userToRole -> userToRole.getUserId().equals(userEntity.getUserId()))
        .findFirst()
        .orElseThrow(()->new RuntimeException("该用户外绑定角色"));

    RoleEntity roleEntity = DBTestData.getAllRoles().stream()
        .filter(roles -> roles.getRoleId().equals(userToRoleEntity.getRoleId()))
        .findFirst()
        .orElseThrow(()->new RuntimeException("角色不存在"));

    List<RoleToPermissionEntity> roleToPermissions = DBTestData.getAllRoleToPermissionS().stream()
        .filter(roleToPermission -> roleToPermission.getRoleId().equals(roleEntity.getRoleId()))
        .collect(Collectors.toList());

    List<PermissionEntity> permissionToPermissions = new ArrayList<>();
    roleToPermissions.forEach(rtp -> {
      DBTestData.getAllPermissions().forEach(permission -> permission.getPermissionId().equals(rtp.getPermissionId()));
    });

    return null;
  }

}
