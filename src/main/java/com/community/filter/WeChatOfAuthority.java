package com.community.filter;

import com.alibaba.fastjson.JSON;
import com.community.entity.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yyc on 2020/3/15.
 */
public class WeChatOfAuthority extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        String[] roles = (String[]) mappedValue;/**获取此请求指定的权限列表*/
        if (!SecurityUtils.getSubject().isAuthenticated()) return false;/**若当前Subject实例没认证，禁止放行*/
        if (roles == null) {
            return true;/**如果权限列表没有参数，放行*/
        }
        for (String role : roles) {
            /**调用hasRole方法判断是否拥有权限列表中的一个，有则放行*/
            if (SecurityUtils.getSubject().hasRole(role)) {
                return true;
            }
        }
        return false;/**没有权限，跳到onAccessDenied处理*/
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        /**执行此方法说明没有权限，因小程序端的页面跳转无法有服务端指定，则只能以json形式告知认证失败的消息*/
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Result<String> res = new Result<>();
        res.setData("你没有权限");
        res.setToken(false);
        res.setMessage("error");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(res));
        return false;
    }
}
