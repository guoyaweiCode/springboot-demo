package com.guoyw.demo210123.result.result;

import lombok.Data;

/**
 * @className: Result
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/23
 **/

@Data
public class Result<T> {

  private String code;

  private String msg;

  private T data;

  public static <T> Result<T> success(T t) {
    Result<T> result = new Result<>();
    result.code = "200";
    result.msg = "ok";
    result.data = t;
    return result;
  }

  public static Result<Object> success() {
    Result<Object> result = new Result<>();
    result.code = "200";
    result.msg = "操作成功";
    return result;
  }
}
