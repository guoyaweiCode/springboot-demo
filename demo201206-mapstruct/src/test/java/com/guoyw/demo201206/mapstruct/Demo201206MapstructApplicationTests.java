package com.guoyw.demo201206.mapstruct;

import com.guoyw.demo201206.mapstruct.conver.UserMapper;
import com.guoyw.demo201206.mapstruct.dto.LoginDto;
import com.guoyw.demo201206.mapstruct.entity.User;
import com.guoyw.demo201206.mapstruct.entity.UserExtend;
import com.guoyw.demo201206.mapstruct.entity.UserStatus;
import com.guoyw.demo201206.mapstruct.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class Demo201206MapstructApplicationTests {

  @Autowired
  UserMapper userMapper;

  @Test
  public 	void contextLoads() {

    User user = new User();
    user.setId(1L)
        .setMemberLevelId(1L)
        .setNickname("张三")
        .setUsername("zhangsan")
        .setStatus(UserStatus.VALID);

    UserExtend userExtend = new UserExtend();
    userExtend.setBirthday("2000-10-10")
        .setSex("男")
        .setBalance(100);



    UserVo userVo = userMapper.userToUserVo(user,userExtend);
    log.info(userVo.toString());
    LoginDto loginDto = userMapper.userToLoginDto(user);
    log.info(loginDto.toString());
    userVo.setPhone("13133434333333");
    User user1 = userMapper.userVoToUser(userVo);
    log.info(userVo.toString());

  }

}
