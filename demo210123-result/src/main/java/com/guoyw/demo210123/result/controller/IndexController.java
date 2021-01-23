package com.guoyw.demo210123.result.controller;

import com.guoyw.demo210123.result.annotation.ResponseResult;
import com.guoyw.demo210123.result.exception.BusinessException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: index
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/23
 **/

@RestController
@RequestMapping("/index")
@Api(value = "IndexController",description = "测试requestResult")
@ResponseResult
public class IndexController {

  @GetMapping("/demo")
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

  @GetMapping("/demo2")
  public String demo2(){

    throw new BusinessException("code.110");
  }


  @GetMapping("/demo3")
  public void demo3(){

  }


}
