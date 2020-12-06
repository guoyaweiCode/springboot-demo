package com.guoyw.demo201206.mapstruct.conver;

import com.guoyw.demo201206.mapstruct.dto.LoginDto;
import com.guoyw.demo201206.mapstruct.entity.User;
import com.guoyw.demo201206.mapstruct.entity.UserExtend;
import com.guoyw.demo201206.mapstruct.vo.UserVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @program: spring-boot-demo
 * @description:
 * @author: guoyw
 * @create: 2020-12-06 19:48
 **/

@Mapper(componentModel = "spring")
public interface UserMapper {

//  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "constant",constant = "1")
  // 这是处理数字格式化的操作，遵循java.text.DecimalFormat的规范:
  @Mapping(target = "balance",source = "userExtend.balance",numberFormat = "$#.00")
  UserVo userToUserVo(User user,UserExtend userExtend);

  @Mapping(target = "password",source = "password",defaultValue = "123456")
  LoginDto userToLoginDto(User user);

  @InheritConfiguration(name = "userToLoginDto")
  User userVoToUser(UserVo userVo);

}
