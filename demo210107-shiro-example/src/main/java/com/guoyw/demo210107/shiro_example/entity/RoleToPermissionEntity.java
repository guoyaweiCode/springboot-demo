package com.guoyw.demo210107.shiro_example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author guoyw
 * @version 1.0
 * @description: TODO
 * @date 2021/1/8 16:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RoleToPermissionEntity {

  private Long roleId;

  private Long permissionId;


}
