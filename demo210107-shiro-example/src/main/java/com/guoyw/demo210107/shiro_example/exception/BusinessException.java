package com.guoyw.demo210107.shiro_example.exception;

/**
 * @className: BusinessException
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/9
 **/

public class BusinessException extends RuntimeException{

  public BusinessException(){
    super();
  }
  public BusinessException(String messages){
    super(messages);
  }
  public BusinessException(String message, Throwable cause){
    super(message,cause);
  }

}
