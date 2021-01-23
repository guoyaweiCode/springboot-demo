package com.guoyw.demo210123.result.exception.handler;

import com.guoyw.demo210123.result.exception.BusinessException;
import com.guoyw.demo210123.result.result.ErrorResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: BusinessExceptionHandler
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/23
 **/

@RestControllerAdvice
public class BusinessExceptionHandler {

  @Autowired(required = false)
  protected MessageSource messageSource;

  @ExceptionHandler(BusinessException.class)
  @ResponseBody
  protected ErrorResult businessExceptionHandler(BusinessException exception) {
    ErrorResult result = new ErrorResult();
    String code = exception.getMessage();
    String msgKey = exception.getClass().getSimpleName() + "." + code;
    String msg;
    if (messageSource != null) {
      msg = messageSource.getMessage(msgKey, exception.getParams(), code, LocaleContextHolder.getLocale());
    } else {
      msg = code;
    }
    result.setCode(code);
    result.setMsg(msg);

    return result;
  }
}
