package com.community.controller;

import com.community.entity.Menu;
import com.community.entity.MenuDetail;
import com.community.entity.Page;
import com.community.entity.Result;
import com.community.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yyc on 2020/4/24.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * @Description: 更新，添加今日菜谱
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping({"/insertInfo", "/updateInfo"})
    @ResponseBody
    public Result<String> updateOrInsertMenuInfo(Menu record, @RequestParam(value = "editId", required = false) String editId) {
        try {
            if (editId != null) {
                menuService.updateMenu(record, editId);
                return new Result<>("修改成功", "success", true);
            } else {
                menuService.insertMenu(record);
                return new Result<>("添加成功", "success", true);
            }
        } catch (DuplicateKeyException e) {
            return new Result<>("今日菜谱已发布请勿重复", "success", true);
        } catch (Exception e) {
            return new Result<>("系统异常", "error", false);
        }
    }

    /**
     * @Description: 验证今日菜谱是否发布
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/validateMenu")
    @ResponseBody
    public Result<Menu> getMenuInfo() {
        try {
            Menu menu = menuService.getMenuInfo();
            return new Result<>(menu, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "error", false);
        }
    }

    /**
     * @Description: 验证是否预约
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/validateReservation")
    @ResponseBody
    public Result<Menu> validateReservation(@RequestParam String userId) {
        return menuService.validateReservation(userId);
    }

    @RequestMapping("/deleteReservation")
    @ResponseBody
    public Result<String> deleteReservation(@RequestParam String userId, @RequestParam String menuId) {
        try {
            menuService.deleteReservation(userId, menuId);
            return new Result<>("取消成功", "success", true);
        } catch (Exception e) {
            return new Result<>("系统异常", "error", false);
        }
    }

    @RequestMapping("/insertReservation")
    @ResponseBody
    public Result<String> insertReservation(@RequestParam String userId, @RequestParam String menuId, @RequestParam String content) {
        try {
            menuService.insertReservation(userId, menuId, content);
            return new Result<>("预约成功", "success", true);
        } catch (DuplicateKeyException e) {
            return new Result<>("请勿重复预约", "success", true);
        } catch (Exception e) {
            return new Result<>("系统异常", "error", false);
        }
    }

    @RequestMapping("/getReservation")
    @ResponseBody
    public Result<Page<MenuDetail>> getReservation(Page<MenuDetail> page) {
        try {
            page = menuService.getReservation(page);
            return new Result<>(page, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "error", false);
        }
    }
}
