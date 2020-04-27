package com.community.realm;

/**
 * Created by yyc on 2020/2/17.
 */

import com.community.dao.UserMapper;
import com.community.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
* @Description: shiro中的Realm组件，进行授权，验证操作
* @Param:
* @Return:
* @Author: yyc
*/
public class CustomRealm extends AuthorizingRealm {

    /**
     * 用户DAP层对象
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /**获取认证的用户名*/
        String userId = (String) principalCollection.getPrimaryPrincipal();
        /**根据用户名，从数据库获取其权限信息*/
        User user = userMapper.selectByPrimaryKey(userId);
        /**将权限信息放入Set集合，并将其封装成AuthorizationInfo的实例并当做返回值，SecurityManager会将其与规定好的权限进行比较*/
        Set<String> roles = new HashSet<>();
        roles.add(user.getAuthority());
        return new SimpleAuthorizationInfo(roles);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /**根据login方法传入的凭证获取用户名*/
        String userName = (String)authenticationToken.getPrincipal();
        /**根据用户名从数据库中查找此用户的信息*/
        User user = userMapper.selectByPrimaryKey(userName);
        /**因密码都需要加密，这里利用用户名进行盐值加密提高加密程度*/
        ByteSource salt = ByteSource.Util.bytes(userName);
        /**将从数据库中获取的用户名，密码，盐值，与自定义Realm名称封装成AuthenticationInfo的实例并当做返回值，SecurityManager会将其与传入的凭证比对*/
        return new SimpleAuthenticationInfo(user.getUserId(), user.getPassword(), salt, getName());
    }
}
