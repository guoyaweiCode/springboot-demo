package com.guoyw.demo210107.shiro_example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: Swagger2Config
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/9
 **/
@Configuration
@EnableSwagger2WebMvc
public class Swagger2Config {

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.guoyw.demo210107.shiro_example"))
        .paths(PathSelectors.any())
        .build()
        .securitySchemes(securitySchemes())
        .securityContexts(securityContexts());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("shrio 标准示例 系统API")
        .description("springboot 使用 shiro 基础版标准示例  ")
        .termsOfServiceUrl("https://github.com/guoyaweiCode")
        .version("1.0")
        .build();
  }

  private List<ApiKey> securitySchemes() {
    //设置请求头信息
    List<ApiKey> result = new ArrayList<>();
    //参数1：字段的名字，参数2：字段的键，参数3：参数位置
    ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
    result.add(apiKey);
    return result;
  }

  //认证的上下文，这里面需要指定哪些接口需要认证
  private List<SecurityContext> securityContexts() {
    //设置需要登录认证的路径
    List<SecurityContext> result = new ArrayList<>();
//    result.add(getContextByPath("/member/.*"));
//    result.add(getContextByPath("/cart/.*"));
//    result.add(getContextByPath("/order/.*"));
//    result.add(getContextByPath("/returnApply/.*"));
    return result;
  }
  private SecurityContext getContextByPath(String pathRegex) {
    return SecurityContext.builder()
        .securityReferences(defaultAuth())
        .forPaths(PathSelectors.regex(pathRegex))
        .build();
  }

  //这个方法是验证的作用域
  private List<SecurityReference> defaultAuth() {
    List<SecurityReference> result = new ArrayList<>();
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    result.add(new SecurityReference("Authorization", authorizationScopes));
    return result;
  }
}
