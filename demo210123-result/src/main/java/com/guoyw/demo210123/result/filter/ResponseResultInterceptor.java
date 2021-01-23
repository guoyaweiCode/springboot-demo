package com.guoyw.demo210123.result.filter;

import com.guoyw.demo210123.result.annotation.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @className: ResponseResultInterceptor
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/23
 **/

@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {
  //标记名称
  public static final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    log.info("ResponseResultInterceptor  ");

    //请求的方法
    if(handler instanceof HandlerMethod){
      final HandlerMethod handlerMethod = (HandlerMethod) handler;
      final Class<?> clazz = handlerMethod.getBeanType();
      final Method method = handlerMethod.getMethod();
      //判断类上是否添加 @ResponseResult 注解
      if(clazz.isAnnotationPresent(ResponseResult.class)){
        log.info("ResponseResultInterceptor ->  clazz");

        //设置此请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
        request.setAttribute(RESPONSE_RESULT_ANN,clazz.getAnnotation(ResponseResult.class));
      }else if (method.isAnnotationPresent(ResponseResult.class)){
        log.info("ResponseResultInterceptor ->  method");

        //设置此请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
        request.setAttribute(RESPONSE_RESULT_ANN,method.getAnnotation(ResponseResult.class));
      }
    }

    return true;
  }

}
