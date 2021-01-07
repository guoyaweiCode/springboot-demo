package com.guoyw.demo210107.shiro_example.vo;

import com.guoyw.demo210107.shiro_example.entity.PermissionEntity;
import com.guoyw.demo210107.shiro_example.entity.RoleEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @className: UserAuthVo
 * @description: 安全认证返回vo 包含 角色&权限
 * @author: guoyw
 * @date: 2021/1/7
 **/

@Data
@Accessors(chain = true)
public class UserAuthVo {

  private Long userId;

  private String username;

  private String mobile;

  private String email;

  private String name;

  private List<RoleEntity> roles;

  private List<PermissionEntity> permissions;

}
