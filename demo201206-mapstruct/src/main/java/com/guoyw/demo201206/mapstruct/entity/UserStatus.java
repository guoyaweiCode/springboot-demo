package com.guoyw.demo201206.mapstruct.entity;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: guoyw
 * @create: 2020-12-06 20:13
 **/

public enum UserStatus {

  VALID("有效"),

  EXPIRE("过期");

  private String userStatusName;

  UserStatus(String userStatusName) {
    this.userStatusName = userStatusName;
  }

  /**
   * 根据状态名称 返回状态
   * @param userStatusName
   * @return
   */
  public UserStatus fromUserStatusName(String userStatusName) {

    for (UserStatus userStatus : UserStatus.values()) {
      if (userStatus.userStatusName.equals(userStatusName)){
        return userStatus;
      }
    }
    return null;
  }

  public String getUserStatusName() {
    return userStatusName;
  }
}
