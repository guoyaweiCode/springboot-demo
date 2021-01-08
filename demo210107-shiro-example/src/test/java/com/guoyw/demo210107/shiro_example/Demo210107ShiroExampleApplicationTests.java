package com.guoyw.demo210107.shiro_example;

import com.guoyw.demo210107.shiro_example.dto.LoginAccountDto;
import com.guoyw.demo210107.shiro_example.service.AuthService;
import com.guoyw.demo210107.shiro_example.vo.UserAuthVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class Demo210107ShiroExampleApplicationTests {

    @Autowired
    AuthService authService;

    @Test
  public   void contextLoads() {
        LoginAccountDto loginAccountDto = new LoginAccountDto();
        loginAccountDto.setUsername("admin");
        loginAccountDto.setPassword("admin");
        UserAuthVo userAuthVo = authService.loginAccount(loginAccountDto);
        log.info(userAuthVo.toString());
    }

}
