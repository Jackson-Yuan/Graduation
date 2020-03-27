package com.community.realm;

/**
 * Created by yyc on 2020/3/27.
 */

import com.community.dao.UserMapper;
import com.community.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 直接进行密码比对，绕过加密算法加密
 * @Param:
 * @Return:
 * @Author: yyc
 */
public class DirectRealm extends AuthenticatingRealm {

    @Autowired
    UserMapper userMapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        User user = userMapper.selectByPrimaryKey(userName);

        return new SimpleAuthenticationInfo(user.getUserId(), user.getPassword(), getName());
    }
}
