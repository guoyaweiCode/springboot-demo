package com.guoyw.demo210107.shiro_example.utils;

import com.guoyw.demo210107.shiro_example.entity.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: DBTestData
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/7
 **/

@Slf4j
public class DBTestData {

  public static List<UserEntity> getAllUsers() {
    List<UserEntity> users = new ArrayList<>();
    users.add(new UserEntity(1L, "admin", "admin", "13100000000", "1111@qq.com", "张三"));
    users.add(new UserEntity(2L, "lisi", "lisi", "13100000001", "2222@qq.com", "李四"));
    users.add(new UserEntity(3L, "wanger", "wanger", "13100000002", "3333@qq.com", "王二"));
    users.add(new UserEntity(4L, "manager", "manager", "13100000003", "4444@qq.com", "耗子尾汁"));
    return users;
  }

  public static List<RoleEntity> getAllRoles() {
    List<RoleEntity> roles = new ArrayList<>();
    roles.add(new RoleEntity(1L, "admin", "管理员"));
    roles.add(new RoleEntity(2L, "manager", "二管理员"));
    roles.add(new RoleEntity(3L, "user", "用户"));
    return roles;
  }

  public static List<PermissionEntity> getAllPermissions() {
    List<PermissionEntity> permissions = new ArrayList<>();
    permissions.add(new PermissionEntity(1L, "main", "首页"));
    permissions.add(new PermissionEntity(2L, "mobile", "查看手机"));
    permissions.add(new PermissionEntity(3L, "salary", "查看工资"));
    return permissions;
  }

  public static List<UserToRoleEntity> getAllUserToRoles() {
    List<UserToRoleEntity> userToRoles = new ArrayList<>();
    userToRoles.add(new UserToRoleEntity(1L, 1L));
    userToRoles.add(new UserToRoleEntity(2L, 3L));
    userToRoles.add(new UserToRoleEntity(3L, 3L));
    userToRoles.add(new UserToRoleEntity(4L, 2L));
    return userToRoles;
  }

  public static List<RoleToPermissionEntity> getAllRoleToPermissionS() {
    List<RoleToPermissionEntity> roleToPermissions = new ArrayList<>();
    roleToPermissions.add(new RoleToPermissionEntity(1L, 1L));
    roleToPermissions.add(new RoleToPermissionEntity(1L, 2L));
    roleToPermissions.add(new RoleToPermissionEntity(1L, 3L));

    roleToPermissions.add(new RoleToPermissionEntity(2L, 1L));
    roleToPermissions.add(new RoleToPermissionEntity(2L, 2L));

    roleToPermissions.add(new RoleToPermissionEntity(3L, 1L));
    roleToPermissions.add(new RoleToPermissionEntity(3L, 3L));
    return roleToPermissions;
  }
}
