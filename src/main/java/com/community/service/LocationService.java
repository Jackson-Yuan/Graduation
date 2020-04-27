package com.community.service;

import com.community.dao.LocationMapper;
import com.community.entity.Location;
import com.community.entity.example.LocationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yyc on 2020/4/12.
 */
@Service
public class LocationService {
    @Autowired
    private LocationMapper locationMapper;

    public List<Location> getHistoryLocation(String id) {
        LocationExample example = new LocationExample();
        example.or().andUserIdEqualTo(id);
        return locationMapper.selectByExample(example);
    }
}
