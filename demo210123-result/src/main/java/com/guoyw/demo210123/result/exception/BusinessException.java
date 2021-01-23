package com.guoyw.demo210123.result.exception;

/**
 * @className: BusinessException
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/23
 **/


public class BusinessException extends RuntimeException{

  private String[] params;

  public BusinessException(String message) {
    super(message);
    this.params = new String[]{};
  }

  public BusinessException(String message, String[] params) {
    super(message);
    this.params = params;
  }

  public BusinessException(String message, String[] params, Throwable cause) {
    super(message, cause);
    this.params = params;
  }

  public String[] getParams() {
    return params;
  }


}
