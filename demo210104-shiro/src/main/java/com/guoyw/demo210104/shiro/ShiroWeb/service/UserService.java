package com.guoyw.demo210104.shiro.ShiroWeb.service;

import com.guoyw.demo210104.shiro.ShiroWeb.entity.UserEntity;
import com.guoyw.demo210104.shiro.ShiroWeb.utils.TestUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: UserService
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/5
 **/

@Service
public class UserService {

  @Resource
  private TestUtil testUtil;

  // 根据用户名获取用户信息
  public UserEntity getUserByUsername(String username){
    UserEntity userEntity = new UserEntity();
    List<UserEntity> queryUsers = testUtil.getAllUsers().stream()
        .filter(user -> user.getUsername().equals(username))
        .collect(Collectors.toList());
    if (queryUsers != null && queryUsers.size() >0){
      BeanUtils.copyProperties(queryUsers.get(0),userEntity);
      return userEntity;
    }
    return  null;
  }
}
