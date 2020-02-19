package com.community.controller;

import com.community.entity.Article;
import com.community.entity.Location;
import com.community.entity.Result;
import com.community.service.ArticleService;
import com.community.service.LocateService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yyc on 2020/2/17.
 */
@Controller
public class LoginController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private LocateService locateService;

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

    /**
    * @Description: 爬虫数据获取
    * @Param: 
    * @Return: 
    * @Author: yyc
    */
    @RequestMapping("/health")
    @ResponseBody
    public Result<List<Article>> getHealthMessage(){
        List<Article> articles = articleService.getHealthMessage();
        if (articles == null) return new Result<>(null, "fail", "404");
        else return new Result<>(articles, "success", "200");
    }

    @RequestMapping("/address")
    @ResponseBody
    public Result<Location> getLocation(@RequestParam(value = "ipAddress", required = false)String ipAddress){
        Location location = locateService.getLocation(ipAddress);

        if (location == null) return new Result<>(null, "fail", "404");
        else return new Result<>(location, "success", "200");
    }
}
