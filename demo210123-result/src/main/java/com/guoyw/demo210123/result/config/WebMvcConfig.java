package com.guoyw.demo210123.result.config;

import com.guoyw.demo210123.result.filter.ResponseResultInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @className: WebMvcConfig
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/23
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Autowired
  private ResponseResultInterceptor responseResultInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new ResponseResultInterceptor())
        .addPathPatterns("/**");
    registry.addInterceptor(responseResultInterceptor);
    WebMvcConfigurer.super.addInterceptors(registry);
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    // 第一种方式是将 json 处理的转换器放到第一位，使得先让 json 转换器处理返回值，这样 String转换器就处理不了了。
    converters.add(0, new MappingJackson2HttpMessageConverter());
    // 第二种就是把String类型的转换器去掉，不使用String类型的转换器
    // converters.removeIf(httpMessageConverter -> httpMessageConverter.getClass() == StringHttpMessageConverter.class);
  }
}
