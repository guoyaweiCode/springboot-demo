package com.guoyw.demo210123.result.controller;

import com.guoyw.demo210123.result.annotation.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: MainCController
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/23
 **/

@RestController
@RequestMapping("/main")
@Api(value = "MainController",description = "测试requestResult")
public class MainController {

  @GetMapping("/demo")
  @ResponseResult
  public String demo(){
    return "hello 这里是 demo 哟。";
  }

  @GetMapping("/demo1")
  public Map demo1(){
    Map map = new HashMap();
    map.put("name","guoyw");
    map.put("age","18");

    return map;
  }
}
