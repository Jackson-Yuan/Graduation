package com.community.filter;

import com.alibaba.fastjson.JSON;
import com.community.entity.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yyc on 2020/3/15.
 */
public class WeChatOfAuthentication extends PathMatchingFilter {
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if (SecurityUtils.getSubject().isAuthenticated()) return true;
        else {
            Result<String> res = new Result<>();
            res.setData("你没有认证");
            res.setMessage("error");
            res.setToken(false);
            HttpServletResponse rep = (HttpServletResponse) response;
            rep.getWriter().write(JSON.toJSONString(res));
            return false;
        }
    }
}
