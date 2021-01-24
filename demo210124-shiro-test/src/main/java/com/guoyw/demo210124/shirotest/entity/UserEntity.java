package com.guoyw.demo210124.shirotest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @className: UserEntity
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/4
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

  private String userId;
  private String username;
  private String mobile;
  private String password;

  private List<String> roles;
  private List<String> permissions;


}
