package com.community.dao;

import com.community.entity.Try;
import com.community.entity.example.TryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TryMapper {
    long countByExample(TryExample example);

    int deleteByExample(TryExample example);

    int deleteByPrimaryKey(String id);

    int insert(Try record);

    int insertSelective(Try record);

    List<Try> selectByExample(TryExample example);

    Try selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Try record, @Param("example") TryExample example);

    int updateByExample(@Param("record") Try record, @Param("example") TryExample example);

    int updateByPrimaryKeySelective(Try record);

    int updateByPrimaryKey(Try record);
}