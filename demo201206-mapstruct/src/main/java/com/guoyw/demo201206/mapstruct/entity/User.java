package com.guoyw.demo201206.mapstruct.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: guoyw
 * @create: 2020-12-06 19:08
 **/

@Data
@Accessors(chain = true)
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private Long memberLevelId;

  private String username;

  private String password;

  private String nickname;

  private String phone;

  private Integer constant;

  private UserStatus status;
}
