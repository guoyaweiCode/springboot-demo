package com.guoyw.demo210107.shiro_example.exception.handler;

import com.guoyw.demo210107.shiro_example.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: BusinessExceptionHandler
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/9
 **/

@ControllerAdvice
public class BusinessExceptionHandler {

  @ExceptionHandler({BusinessException.class})
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public Map<String,String>  businessExceptionHandler(BusinessException exception){
    Map<String,String> resultMap = new HashMap<>();
    resultMap.put("msg",exception.getMessage());
    resultMap.put("code","200");
    return resultMap;
  }


}
