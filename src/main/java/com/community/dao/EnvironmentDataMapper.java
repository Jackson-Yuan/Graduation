package com.community.dao;

import com.community.entity.Page;
import com.community.entity.data.EnvironmentData;
import com.community.entity.example.EnvironmentDataExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvironmentDataMapper {
    long countByExample(EnvironmentDataExample example);

    int deleteByExample(EnvironmentDataExample example);

    int insert(EnvironmentData record);

    int insertSelective(EnvironmentData record);

    List<EnvironmentData> selectByExample(EnvironmentDataExample example);

    int updateByExampleSelective(@Param("record") EnvironmentData record, @Param("example") EnvironmentDataExample example);

    int updateByExample(@Param("record") EnvironmentData record, @Param("example") EnvironmentDataExample example);

    List<EnvironmentData> queryWithPage(@Param("example") EnvironmentDataExample example, @Param("page") Page page);
}