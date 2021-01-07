package com.guoyw.demo210107.shiro_example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @className: PermissionEntity
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/7
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PermissionEntity {

  private Long permissionId;

  private String permissionName;

  private String description;
}
