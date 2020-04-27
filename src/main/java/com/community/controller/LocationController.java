package com.community.controller;

import com.community.entity.Location;
import com.community.entity.Result;
import com.community.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yyc on 2020/4/12.
 */
@Controller
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @RequestMapping("/show")
    @ResponseBody
    public Result<String> getRoute() {
        return new Result<>("../route/route", "success", true);
    }

    @RequestMapping("/getHistory")
    @ResponseBody
    public Result<List<Location>> getHistory(@RequestParam String id) {
        try {
            List<Location> locationList = locationService.getHistoryLocation(id);
            return new Result<>(locationList, "success", true);
        } catch (Exception e) {
            return new Result<>(null, "error", false);
        }
    }
}
