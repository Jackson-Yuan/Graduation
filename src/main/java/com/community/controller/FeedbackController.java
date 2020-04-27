package com.community.controller;

import com.community.entity.Feedback;
import com.community.entity.Page;
import com.community.entity.Result;
import com.community.exception.ImageValidateException;
import com.community.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by yyc on 2020/4/7.
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/show")
    @ResponseBody
    public Result<String> getRoute(@RequestParam Integer condition) {
        if (condition == 0) return new Result<>("../feedback/feedback", "success", true);
        else if (condition == 1) return new Result<>("../feedbackManage/feedbackManage", "success", true);
        else return null;
    }


    /**
     * @Description: 上传图片接口
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/upLoad")
    @ResponseBody
    public Result<String> getImgPath(@RequestParam MultipartFile img, @RequestParam String feedbackId) {
        try {
            feedbackService.insertImage(img, feedbackId);
            return new Result<>("上传成功", "success", true);
        } catch (ImageValidateException e) {
            return new Result<>(e.getMessage(), "error", false);
        } catch (IOException e) {
            return new Result<>("读取异常", "error", false);
        } catch (Exception e) {
            return new Result<>("系统异常", "error", false);
        }
    }

    /**
     * @Description: 反馈信息接口
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result<String> addFeedBack(Feedback feedback) {
        try {
            feedbackService.insertFeedback(feedback);
            return new Result<>(feedback.getId(), "success", true);
        } catch (Exception e) {
            return new Result<>("系统异常", "error", false);
        }
    }

    /**
     * @Description: 反馈的分页
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/getFeedback")
    @ResponseBody
    public Result<Page<Feedback>> getFeedBack(Page<Feedback> page) {
        try {
            page = feedbackService.queryWithPage(page);
            return new Result<>(page, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "error", false);
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result<String> deleteInfo(@RequestParam String id) {
        try {
            feedbackService.deleteInfo(id);
            return new Result<>("删除成功", "success", true);
        } catch (Exception e) {
            return new Result<>("系统异常", "error", false);
        }
    }

}
