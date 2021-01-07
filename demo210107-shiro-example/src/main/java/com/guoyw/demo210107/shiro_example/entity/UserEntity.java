package com.guoyw.demo210107.shiro_example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @className: UserEntity
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/7
 **/

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

  private Long userId;

  private String username;

  private String password;

  private String mobile;

  private String email;

  private String name;


}
