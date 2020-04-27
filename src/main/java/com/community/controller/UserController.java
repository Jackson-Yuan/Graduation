package com.community.controller;

import com.alibaba.fastjson.JSON;
import com.community.entity.Family;
import com.community.entity.Older;
import com.community.entity.Result;
import com.community.entity.User;
import com.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yyc on 2020/4/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/show")
    @ResponseBody
    public Result<String> getRoute() {
        return new Result<>("../userInfo/userInfo", "success", true);
    }

    @RequestMapping("/updateOlderInfo")
    @ResponseBody
    public Result<String> updateOlder(Older record, @RequestParam Boolean isNew, @RequestParam String editId) {
        try {
            if (isNew) {
                record.setUserId(editId);
                userService.insertOlderInfo(record);
            } else userService.updateOlderInfo(record, editId);
            return new Result<>("修改成功", "success", true);
        } catch (Exception e) {
            return new Result<>("修改失败", "error", false);
        }
    }

    @RequestMapping("/updateFamilyInfo")
    @ResponseBody
    public Result<String> updateFamily(Family record, @RequestParam Boolean isNew, @RequestParam String editId) {
        try {
            if (isNew) {
                record.setUserId(editId);
                userService.insertFamilyInfo(record);
            } else userService.updateFamilyInfo(record, editId);
            return new Result<>("修改成功", "success", true);
        } catch (Exception e) {
            return new Result<>("修改失败", "error", false);
        }
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Result<String> getUserInfo(@RequestParam String authority, @RequestParam String id) {
        try {
            if ("family".equals(authority)) {
                Family family = userService.getFamilyInfo(id);
                return new Result<>(JSON.toJSONString(family), "success", true);
            } else if ("older".equals(authority)) {
                Older older = userService.getOlderInfo(id);
                return new Result<>(JSON.toJSONString(older), "success", true);
            } else return new Result<>("权限错误", "error", false);
        } catch (Exception e) {
            return new Result<>("系统异常", "error", false);
        }
    }

    /**
     * @Description: 获取基本权限接口
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/getBaseInfo")
    @ResponseBody
    public Result<User> getBaseInfo(@RequestParam String userId) {
        try {
            User user = userService.getBaseInfo(userId);
            return new Result<>(user, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "error", false);
        }
    }
}
