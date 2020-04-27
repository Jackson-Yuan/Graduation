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
        /**获取当前Subject的实例，若已认证，放行*/
        if (SecurityUtils.getSubject().isAuthenticated()) return true;
        else {/**若没有认证，因小程序端的页面跳转无法有服务端指定，则只能以json形式告知认证失败的消息*/
            Result<String> res = new Result<>();
            res.setData("你没有认证");
            res.setMessage("error");
            res.setToken(false);
            HttpServletResponse rep = (HttpServletResponse) response;
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=UTF-8");
            rep.getWriter().write(JSON.toJSONString(res));
            return false;/**禁止放行*/
        }
    }
}
