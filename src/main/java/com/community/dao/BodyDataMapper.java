package com.community.dao;

import com.community.entity.Page;
import com.community.entity.data.BodyData;
import com.community.entity.example.BodyDataExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodyDataMapper {
    long countByExample(BodyDataExample example);

    int deleteByExample(BodyDataExample example);

    int insert(BodyData record);

    int insertSelective(BodyData record);

    List<BodyData> selectByExample(BodyDataExample example);

    int updateByExampleSelective(@Param("record") BodyData record, @Param("example") BodyDataExample example);

    int updateByExample(@Param("record") BodyData record, @Param("example") BodyDataExample example);

    List<BodyData> queryWithPage(@Param("example") BodyDataExample example, @Param("page") Page page);

    BodyData queryWithHistory(BodyDataExample example);

    void insertBodyDataInfo(BodyData data);
}