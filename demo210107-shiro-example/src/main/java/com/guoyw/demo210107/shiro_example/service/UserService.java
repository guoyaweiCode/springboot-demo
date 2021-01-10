package com.guoyw.demo210107.shiro_example.service;

import com.guoyw.demo210107.shiro_example.entity.PermissionEntity;
import com.guoyw.demo210107.shiro_example.entity.RoleEntity;
import com.guoyw.demo210107.shiro_example.entity.UserEntity;
import com.guoyw.demo210107.shiro_example.entity.UserToRoleEntity;
import com.guoyw.demo210107.shiro_example.exception.BusinessException;
import com.guoyw.demo210107.shiro_example.utils.DBTestData;
import org.apache.commons.collections.ListUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: UserService
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/9
 **/

@Service
public class UserService {


  public UserEntity getUserByUsernameOrEmail(String usernameOrEmail){
    UserEntity userEntity = DBTestData.getAllUsers().stream()
        .filter(user -> user.getUsername().equals(usernameOrEmail) || user.getEmail().equals(usernameOrEmail))
        .findFirst()
        .orElse(null);

    return userEntity;
  }

  public List<String> getRolesByUserId(Long userId){
    List<RoleEntity> roles = new ArrayList<>();

    List<UserToRoleEntity> userToRoles = DBTestData.getAllUserToRoles().stream()
        .filter(userToRole -> userToRole.getUserId().equals(userId))
        .collect(Collectors.toList());

    userToRoles.forEach(userToRole -> {
      RoleEntity roleEntity = DBTestData.getAllRoles().stream()
          .filter(role -> role.getRoleId().equals(userToRole.getRoleId()))
          .findFirst()
          .orElse(null);

      if(roleEntity != null){
        roles.add(roleEntity);
      }
    });

    if(roles.size() > 0){
      List<String> result = roles.stream().map(RoleEntity::getRoleName).collect(Collectors.toList());
      return result;
    }

    return  null;
  }

  public List<String> getPermissionByRoleIds(List<String> roleIds) {
    List<PermissionEntity> permissions = new ArrayList<>();
    for(String roleId : roleIds){
      List<PermissionEntity> entitys = DBTestData.getAllPermissions().stream()
          .filter(permission -> permission.getPermissionId().equals(roleId))
          .collect(Collectors.toList());

      permissions.addAll(entitys);
    }
    if(permissions.size() > 0){
      List<String> result = permissions.stream().map(PermissionEntity::getPermissionName).collect(Collectors.toList());
      return result;
    }
    return null;
  }

  public List<String> getPermissionByRoleIds(String... roleIds) {
    List<String> roleIdList = Arrays.asList(roleIds);
    return getPermissionByRoleIds(roleIdList);
  }

}
