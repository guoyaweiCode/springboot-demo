package com.guoyw.demo210107.shiro_example.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @className: MyModularRealmAuthenticator
 * @description: TODO 类描述
 * @author: guoyw
 * @date: 2021/1/10
 **/

/**
 * 自定义Authenticator
 * 注意，当需要分别定义处理普通用户和管理员验证的Realm时，对应Realm的全类名应该包含字符串“User”，或者“Admin”。
 * 并且，他们不能相互包含，例如，处理普通用户验证的Realm的全类名中不应该包含字符串"Admin"。
 */
@Slf4j
public class MyModularRealmAuthenticator extends ModularRealmAuthenticator {
  @Override
  protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
      throws AuthenticationException {

    log.info("--> 进入 [MyModularRealmAuthenticator.doAuthenticate] 验证的Realm");

    // 判断getRealms()是否返回为空
    assertRealmsConfigured();

    MyUsernamePasswordToken token=(MyUsernamePasswordToken)authenticationToken;
    // 登录类型
    String loginType = token.getType();

    System.out.println("loginType:"+loginType);
    // 所有Realm
    Collection<Realm> realms = getRealms();
    // 登录类型对应的所有Realm
    Collection<Realm> typeRealms = new ArrayList<>();
    HashMap<String,Realm> realmHashMap=new HashMap<>(realms.size());
    for (Realm realm : realms) {
      realmHashMap.put(realm.getName(),realm);
//            if (realm.getName().contains(loginType)){
//                typeRealms.add(realm);
//            }

    }

    System.out.println("realmHashMap.get(loginType):"+realmHashMap.get(loginType));

    if (realmHashMap.get(loginType)!=null){
      return doSingleRealmAuthentication(realmHashMap.get(loginType), token);
    }else {
      return doMultiRealmAuthentication(realms, token);
    }

    // 判断是单Realm还是多Realm
//        if (typeRealms.size() == 1)
//            return doSingleRealmAuthentication(typeRealms.iterator().next(), token);
//        else
//            return doMultiRealmAuthentication(typeRealms, token);
  }

//    private static HashMap<String,Realm> switchCollectionToMap(){
//        HashMap<String,Realm>
//
//        return
//    }
}