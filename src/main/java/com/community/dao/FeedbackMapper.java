package com.community.dao;

import com.community.entity.Feedback;
import com.community.entity.Page;
import com.community.entity.example.FeedbackExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackMapper {
    Integer countByExample(FeedbackExample example);

    int deleteByExample(FeedbackExample example);

    int deleteByPrimaryKey(String id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    List<Feedback> selectByExampleWithBLOBs(FeedbackExample example);

    List<Feedback> selectByExample(FeedbackExample example);

    Feedback selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByExampleWithBLOBs(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKeyWithBLOBs(Feedback record);

    int updateByPrimaryKey(Feedback record);

    List<Feedback> selectByPage(@Param("example") FeedbackExample example, @Param("page") Page page);
}