package com.community.dao;

import com.community.entity.Notice;
import com.community.entity.Page;
import com.community.entity.example.NoticeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {
    long countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(String id);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExampleWithBLOBs(NoticeExample example);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);

    List<Notice> selectByExampleWithPage(@Param("example") NoticeExample example, @Param("page") Page page);

    List<Notice> selectByExampleAndParticipantWithPage(@Param("example") NoticeExample example, @Param("page") Page page);

    Integer getCountWithParticipant(NoticeExample example);

    Integer getCountWithNotice(NoticeExample example);

    void insertParticipant(@Param("noticeId") String noticeId, @Param("userId") String userId);

    void deleteWithParticipant(@Param("noticeId") String noticeId, @Param("userId") String userId);
}