package com.guoyw.demo210107.shiro_example.dto;

import lombok.Data;

/**
 * @className: LoginMobileDto
 * @description: 手机号 dto
 * @author: guoyw
 * @date: 2021/1/7
 **/

@Data
public class LoginMobileDto {

  private String mobile;

  private String verifyCode;

}
