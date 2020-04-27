package com.community.controller;

import com.community.entity.Result;
import com.community.entity.User;
import com.community.service.WeChatService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yyc on 2020/3/18.
 */
@Controller
public class WeChatController {
    @Autowired
    private WeChatService weChatService;

    @RequestMapping("/getOpenId")
    public void getOpenId(@RequestParam("jsCode") String jsCode, HttpServletResponse response) throws IOException {
        String json = weChatService.getOpenId(jsCode);
        response.getWriter().write(json);
    }

    @RequestMapping("/validateUser")
    @ResponseBody
    public Result<User> getBaseInfo(@RequestParam String openId) {
        User user = weChatService.getUserByOpenId(openId);
        if (user == null) return new Result<>(null, "error", false);
        else return new Result<>(user, "success", true);
    }

    @RequestMapping("/bindWeChat")
    @ResponseBody
    public Result<User> bindWeChat(@RequestParam String userId, @RequestParam String password,
                                   @RequestParam String openId) {
        try {
            User user = weChatService.bindUserIdByOpenId(userId, openId, password);
            if (user != null) return new Result<>(user, "绑定成功", true);
            else return new Result<>(null, "查无此人", false);
        } catch (Exception e) {
            return new Result<>(null, "系统异常", false);
        }
    }

    @RequestMapping("/registerByWeChat")
    @ResponseBody
    public Result<User> registerUser(User user) {
        try {
            User res = weChatService.registerUser(user);
            return new Result<>(res, "success", true);
        } catch (DuplicateKeyException e) {
            return new Result<>(null, "用户名已被注册", false);
        } catch (Exception e) {
            return new Result<>(null, "系统异常", false);
        }
    }

    @RequestMapping("/weChatByLogin")
    @ResponseBody
    public Result<String> login(@RequestParam String userId, @RequestParam String password) {
        /**获取用户名密码，封装成一个凭证*/
        UsernamePasswordToken token = new UsernamePasswordToken(userId, password);
        /**获取当前Subject实例*/
        Subject subject = SecurityUtils.getSubject();
        /**判断是否认证*/
        if (!subject.isAuthenticated()) {
            try {
                /**若没认证，则调用相关方法进行认证*/
                subject.login(token);
            } catch (AuthenticationException e) {
                return new Result<>("认证失败，请联系社区管理员或重新登录", "fail", false);
            }
        }
        return new Result<>("身份已认证", "success", true);
    }

}
