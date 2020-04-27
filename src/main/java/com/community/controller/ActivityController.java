package com.community.controller;

import com.community.entity.Notice;
import com.community.entity.Page;
import com.community.entity.Result;
import com.community.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by yyc on 2020/4/2.
 */

/**
 * @Description: 活动相关处理
 * @Param:
 * @Return:
 * @Author: yyc
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/show")
    @ResponseBody
    public Result<String> getCorrectUrl(@RequestParam Integer condition) {
        if (condition == 0) return new Result<>("../activity/activity", "success", true);
        else if (condition == 1) return new Result<>("../activityList/activityList", "success", true);
        else return null;

    }

    @RequestMapping("/release")
    @ResponseBody
    public Result<String> releaseActivity(Notice notice) {
        try {
            noticeService.insertNotice(notice);
            return new Result<>("发布成功", "success", true);
        } catch (Exception e) {
            return new Result<>("系统异常", "error", false);
        }
    }

    /**
     * @Description: 分页查询接口
     * @Param: page: 分页数据 date: 基于当前时间查询可参与活动 userId: 查询自己所发布的活动 isParticipant: 区分查自己参与还是自己所发布
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/queryPage")
    @ResponseBody
    public Result<Page<Notice>> queryPage(Page<Notice> page,
                                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") @RequestParam(value = "date", required = false) Date date,
                                          @RequestParam(required = false) String userId, @RequestParam Boolean isParticipant) {
        try {
            Page<Notice> queryRes = noticeService.selectNoticeWithPage(page, date, userId, isParticipant);
            return new Result<>(queryRes, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "系统异常", false);
        }
    }

    /**
     * @Description: 获取活动细节，及发起人姓名
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/getDetail")
    @ResponseBody
    public Result<Notice> getIndividualActivityDetail(@RequestParam String noticeId) {
        try {
            Notice notice = noticeService.getIndividualDetail(noticeId);
            return new Result<>(notice, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "系统异常", false);
        }
    }

    /**
     * @Description: 报名
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/signUp")
    @ResponseBody
    public Result<String> signUp(@RequestParam String noticeId, @RequestParam String userId) {
        try {
            noticeService.insertParticipant(noticeId, userId);
            return new Result<>("报名成功", "success", true);
        } catch (DuplicateKeyException e) {
            return new Result<>("请勿重复报名", "success", true);
        } catch (Exception e) {
            return new Result<>("系统异常", "error", false);
        }
    }

    /**
     * @Description: 删除，报名信息或活动信息
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result<String> delete(@RequestParam String noticeId, @RequestParam(required = false) String userId) {
        try {
            noticeService.delete(noticeId, userId);
            return new Result<>("操作成功", "success", true);
        } catch (Exception e) {
            return new Result<>("系统异常", "error", false);
        }
    }
}
