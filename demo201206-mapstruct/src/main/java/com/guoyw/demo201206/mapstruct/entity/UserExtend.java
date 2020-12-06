package com.guoyw.demo201206.mapstruct.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: guoyw
 * @create: 2020-12-06 22:28
 **/

@Data
@Accessors(chain = true)
public class UserExtend {

  private String birthday;

  private String sex;

  private Integer balance;
}
