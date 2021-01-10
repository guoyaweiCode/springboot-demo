package com.guoyw.demo210107.shiro_example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @className: LoginAccountDto
 * @description: 账号登录 dto  可以使用 用户名 和 邮箱
 * @author: guoyw
 * @date: 2021/1/7
 **/

@Data
public class LoginAccountDto {

  @ApiModelProperty(value = "用户名")
  private String username;

  @ApiModelProperty(value = "密码")
  private String password;

}
