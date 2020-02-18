package com.community.realm;

import com.community.dao.UserMapper;
import com.community.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yyc on 2020/2/17.
 */
/**
* @Description: shiro中的Realm组件，进行授权，验证操作
* @Param:
* @Return:
* @Author: yyc
*/
public class CustomRealm extends AuthorizingRealm{

    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String)authenticationToken.getPrincipal();

        User user = userMapper.selectByPrimaryKey(userName);

        ByteSource salt = ByteSource.Util.bytes(userName);

        return new SimpleAuthenticationInfo(user.getUserId(), user.getPassword(), salt, getName());
    }
}
