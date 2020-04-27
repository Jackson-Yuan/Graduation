package com.community.controller;

import com.community.entity.Page;
import com.community.entity.Result;
import com.community.entity.data.BodyData;
import com.community.entity.data.EnvironmentData;
import com.community.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by yyc on 2020/4/10.
 */
@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;

    @RequestMapping("/show")
    @ResponseBody
    public Result<String> getRoute() {
        return new Result<>("../dataShow/dataShow", "success", true);
    }

    @RequestMapping("/getBodyData")
    @ResponseBody
    public Result<Page<BodyData>> getBodyData(Page<BodyData> page, @RequestParam String familyId) {
        try {
            page = dataService.getBodyData(page, familyId);
            return new Result<>(page, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "error", false);
        }
    }

    @RequestMapping("/getEnvironmentData")
    @ResponseBody
    public Result<Page<EnvironmentData>> getEnvironmentData(Page<EnvironmentData> page, @RequestParam String familyId) {
        try {
            page = dataService.getEnvironmentData(page, familyId);
            return new Result<>(page, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "error", false);
        }
    }

    /**
     * @Description: 查询7天历史数据
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @RequestMapping("/getHistoryBodyData")
    @ResponseBody
    public Result<List<BodyData>> getHistory(@RequestParam String familyId, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") @RequestParam Date current) {
        try {
            List<BodyData> dataList = dataService.getHistoryBodyData(familyId, current);
            return new Result<>(dataList, " success", true);
        } catch (Exception e) {
            return new Result<>(null, "error", false);
        }
    }
}
