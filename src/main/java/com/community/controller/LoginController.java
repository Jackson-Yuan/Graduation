package com.community.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yyc on 2020/2/17.
 */
@Controller
public class LoginController {

    /**
    * @Description: 登录接口,安全验证
    * @Param: 登录名 + 密码
    * @Return:
    * @Author: yyc
    */
    @RequestMapping("/login")
    public String loginValidate(@RequestParam(value = "userName", required = false) String userName,
                                @RequestParam(value = "password", required = false) String password, Model model) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        Subject subject = SecurityUtils.getSubject();

        token.setRememberMe(true);

        if (!subject.isAuthenticated() && !subject.isRemembered()){
            try{
                if (token.getPrincipal() == null) throw new NullPointerException();
                subject.login(token);
            }catch (NullPointerException e){
                return "redirect:/login.jsp";
            }catch (Exception e){
                model.addAttribute("error", e.getMessage());
                return "login";
            }
        }

        return "redirect:/index.jsp";

    }
}
