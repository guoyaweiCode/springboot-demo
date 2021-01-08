package com.guoyw.demo210107.shiro_example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author guoyw
 * @version 1.0
 * @description: TODO
 * @date 2021/1/8 16:22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserToRoleEntity {

  private Long userId;

  private Long roleId;

}
