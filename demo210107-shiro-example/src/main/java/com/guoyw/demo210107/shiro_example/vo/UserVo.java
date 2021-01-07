package com.guoyw.demo210107.shiro_example.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @className: UserVo
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/7
 **/

@Data
@Accessors(chain = true)
public class UserVo {

  private Long userId;

  private String mobile;

  private String email;

  private String name;

}
