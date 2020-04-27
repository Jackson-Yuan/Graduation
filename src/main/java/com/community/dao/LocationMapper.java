package com.community.dao;

import com.community.entity.Location;
import com.community.entity.example.LocationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationMapper {
    long countByExample(LocationExample example);

    int deleteByExample(LocationExample example);

    int insert(Location record);

    int insertSelective(Location record);

    List<Location> selectByExample(LocationExample example);

    int updateByExampleSelective(@Param("record") Location record, @Param("example") LocationExample example);

    int updateByExample(@Param("record") Location record, @Param("example") LocationExample example);
}