package com.guoyw.demo210107.shiro_example.conver;

import com.guoyw.demo210107.shiro_example.entity.PermissionEntity;
import com.guoyw.demo210107.shiro_example.entity.RoleEntity;
import com.guoyw.demo210107.shiro_example.entity.UserEntity;
import com.guoyw.demo210107.shiro_example.vo.UserAuthVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author guoyw
 * @version 1.0
 * @description: TODO
 * @date 2021/1/8 17:30
 */

@Mapper(componentModel = "spring")
public interface UserAuthConver {

  @Mapping(target = "roles",source = "roles")
  @Mapping(target = "permissions",source = "permissions")
  UserAuthVo toUserAuthVo(UserEntity user, List<RoleEntity> roles, List<PermissionEntity> permissions);

}
