package com.community.filter;

import com.alibaba.fastjson.JSON;
import com.community.entity.Result;
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
        String[] roles = (String[]) mappedValue;
        if (roles == null) {
            return true;/**如果没有设置角色参数，默认成功*/
        }
        for (String role : roles) {
            if (getSubject(servletRequest, servletResponse).hasRole(role)) {
                return true;
            }
        }
        return false;/**跳到onAccessDenied处理*/
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Result<String> res = new Result<>();
        res.setData("你没有权限");
        res.setToken(false);
        res.setMessage("error");
        response.getWriter().write(JSON.toJSONString(res));
        return false;
    }
}
