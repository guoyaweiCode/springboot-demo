package com.guoyw.demo201206.mapstruct.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: guoyw
 * @create: 2020-12-06 19:11
 **/

@Data
public class LoginDto implements Serializable {

  private String username;

  private String password;

}
