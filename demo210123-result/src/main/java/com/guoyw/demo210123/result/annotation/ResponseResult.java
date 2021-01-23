package com.guoyw.demo210123.result.annotation;

    import java.lang.annotation.*;

/**
 * @className: ResponseResult
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/23
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
