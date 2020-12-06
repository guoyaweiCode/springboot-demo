package com.guoyw.demo201206.mapstruct.vo;

import com.guoyw.demo201206.mapstruct.entity.UserStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: guoyw
 * @create: 2020-12-06 19:12
 **/

@Data
public class UserVo implements Serializable {

  private Long id;

  private Long memberLevelId;

  private String nickname;

  private String phone;

  private UserStatus status;

  private Integer constant;

  private String birthday;

  private String sex;

  private Integer balance;

}
