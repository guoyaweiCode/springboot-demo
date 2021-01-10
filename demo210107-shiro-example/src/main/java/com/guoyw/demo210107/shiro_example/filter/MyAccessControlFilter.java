package com.guoyw.demo210107.shiro_example.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @className: MyAccessControlFilter
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/10
 **/

@Slf4j
public class MyAccessControlFilter extends AccessControlFilter {

  /**
   *
   * 表示是否允许访问；mappedValue就是[urls]配置中拦截器参数部分，如果允许访问返回true，否则false；
   * (感觉这里应该是对白名单（不需要登录的接口）放行的)
   * 如果isAccessAllowed返回true则onAccessDenied方法不会继续执行
   * 这里可以用来判断一些不被通过的链接（个人备注）
   * * 表示是否允许访问 ，如果允许访问返回true，否则false；
   * @param servletRequest
   * @param servletResponse
   * @param o 表示写在拦截器中括号里面的字符串 mappedValue 就是 [urls] 配置中拦截器参数部分
   * @return
   * @throws Exception
   * */
  @Override
  protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
    String url = getPathWithinApplication(servletRequest);
    log.info("--> 【MyAccessControlFilter.isAccessAllowed】允许访问 url："+url);
    Subject subject = getSubject(servletRequest,servletResponse);
    log.info("subject.isPermitted(url);"+subject.isPermitted(url));


    return false;
  }

  /**
   * 表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；如果返回false表示该拦截器实例已经处理了，将直接返回即可。
   * onAccessDenied是否执行取决于isAccessAllowed的值，如果返回true则onAccessDenied不会执行；如果返回false，执行onAccessDenied
   * 如果onAccessDenied也返回false，则直接返回，不会进入请求的方法（只有isAccessAllowed和onAccessDenied的情况下）
   * */
  @Override
  protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
    log.info("--> 【MyAccessControlFilter.onAccessDenied】不允许访问");
    // 假装token验正通过了
    return true;


/*    try {
      //校验身份
      //逻辑是什么?
      //第一步：获取token
      String token=request.getHeader(Constant.REQ_TOKEN);
      //第二步：看下这个token是否否为""
      if(StringUtils.isEmpty(token)){  //说明你娃身份是非法的
        throw new BusinessException(400001,"用户的请求的token不能为空");
      }else{  //说明用户带了token
        //逻辑
        //这里要将token进行封装  封装完了 交给shiro去做认证  看下身份是否合法
        CustomToken customToken = new CustomToken(token);
        //记住下面这个类 在用户第一次登陆的时候  并不会执行
        // 这个执行的时候 是在认证成功之后访问其他资源的
        //的时候 机械能给你身份校验的
        getSubject(servletRequest,servletResponse).login(customToken);
      }
    } catch (BusinessException e) {
      //如果是这个异常：返回JSON告诉前端出现问题了
      resultResponse(e.getMessageCode(),e.getDefaultMesaage(),servletResponse);
      return false;
    } catch (AuthenticationException e) {  //校验没通过的异常
      //  e.getCause() ：返回的是当前异常的实例
      if(e.getCause() instanceof BusinessException){ //表示返回的是我们自定义的异常
        //将异常的实例进行转换
        BusinessException err= (BusinessException) e.getCause();
        resultResponse(err.getMessageCode(),err.getDefaultMesaage(),servletResponse);
      }else{  //如果执行到这里  说明 这个异常是shiro返回的
        resultResponse(400001,"用户的认证是失败的",servletResponse);
      }
      return false;
    }catch (AuthorizationException e){
      //  e.getCause() ：返回的是当前异常的实例
      if(e.getCause() instanceof BusinessException){ //表示返回的是我们自定义的异常
        //将异常的实例进行转换
        BusinessException err= (BusinessException) e.getCause();
        resultResponse(err.getMessageCode(),err.getDefaultMesaage(),servletResponse);
      }else{  //如果执行到这里  说明 这个异常是shiro返回的
        resultResponse(403001,"用户没有访问权限",servletResponse);
      }
      return false;
    }catch (Exception e){  //这个分支就捕获一些未考虑的异常了
      //  e.getCause() ：返回的是当前异常的实例
      if(e.getCause() instanceof BusinessException){ //表示返回的是我们自定义的异常
        //将异常的实例进行转换
        BusinessException err= (BusinessException) e.getCause();
        resultResponse(err.getMessageCode(),err.getDefaultMesaage(),servletResponse);
      }else{  //如果执行到这里  说明 这个异常是shiro返回的
        resultResponse(500001,"系统出现了异常",servletResponse);
      }
      return false;
    }
    //当前的方法返回true才放行  否则这个程序也就执行到这里了....
    return true;*/
  }
}
