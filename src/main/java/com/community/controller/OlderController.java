package com.community.controller;

import com.community.entity.Older;
import com.community.entity.Result;
import com.community.service.OlderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yyc on 2020/4/6.
 */
@Controller
@RequestMapping("/older")
public class OlderController {
    @Autowired
    private OlderService olderService;

    /**
     * @Description: 根据活动id查找报名人信息, 也可配合useId检查是否参与
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/getDetailByActivity")
    @ResponseBody
    public Result<List<Older>> getDetailByActivity(@RequestParam String noticeId, @RequestParam(required = false) String userId) {
        try {
            List<Older> olders = olderService.getOldersByActivity(noticeId, userId);
            return new Result<>(olders, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "error", false);
        }
    }

    /**
     * @Description: 根据id查找老人所有信息
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/getDetail")
    @ResponseBody
    public Result<Older> getDetail(@RequestParam String userId) {
        try {
            Older older = olderService.getDetail(userId);
            return new Result<>(older, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "error", false);
        }
    }

    /**
     * @Description: 根据家属id查询老人
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/getDetailByFamily")
    @ResponseBody
    public Result<List<Older>> getDetailByFamily(@RequestParam String familyId) {
        try {
            List<Older> olderList = olderService.getOdersByFamily(familyId);
            return new Result<>(olderList, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "error", false);
        }
    }
}
