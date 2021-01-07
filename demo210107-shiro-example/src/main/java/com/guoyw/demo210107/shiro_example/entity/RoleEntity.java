package com.guoyw.demo210107.shiro_example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @className: RoleEntity
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/7
 **/

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

  private Long roleId;

  private String roleName;

  private String description;

}
