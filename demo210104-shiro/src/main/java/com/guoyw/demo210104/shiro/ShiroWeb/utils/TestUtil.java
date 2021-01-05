package com.guoyw.demo210104.shiro.ShiroWeb.utils;

import com.guoyw.demo210104.shiro.ShiroWeb.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: TestUtil
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/5
 **/

@Component
public class TestUtil {

  // 模拟数据库中的用户数据
  private static List<UserEntity> aEntities;

  public static List<UserEntity> getAllUsers(){
    if(aEntities == null){
      aEntities = new ArrayList<>();;
      aEntities.add(new UserEntity("1","admin","admin", Arrays.asList("admin"),Arrays.asList("mobile","salary")));
      aEntities.add(new UserEntity("2","manager","manager", Arrays.asList("manager"),Arrays.asList("mobile")));
      aEntities.add(new UserEntity("3","worker","worker", Arrays.asList("worker"),Arrays.asList("salary")));
    }
   return aEntities;
  }
}
