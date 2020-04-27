package com.community.filter;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * Created by yyc on 2020/4/2.
 */

/**
 * @Description: 小程序是不带cookie的，只能手动带上且需要重写shiro分析cookie的方法
 * @Param:
 * @Return:
 * @Author: yyc
 */
public class CustomSessionManager extends DefaultWebSessionManager {
    /**
     * 这个是服务端要返回给客户端，
     */
    public final static String TOKEN_NAME = "WECHAT_TOKEN";
    /**
     * 这个是客户端请求给服务端带的header
     */
    public final static String HEADER_TOKEN_NAME = "weChatToken";
    public final static Logger LOG = LoggerFactory.getLogger(CustomSessionManager.class);
    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    /**
     * 重写getSessionId,分析请求头中的指定参数，做用户凭证sessionId
     */
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String id = WebUtils.toHttp(request).getHeader(HEADER_TOKEN_NAME);
        if (StringUtils.isEmpty(id)) {
            /**如果没有携带id参数则按照父类的方式在cookie进行获取**/
            return super.getSessionId(request, response);
        } else {
            /**如果请求头中有weChatToken 则其值为sessionId*/
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        }
    }
}
