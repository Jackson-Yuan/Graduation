package com.community.dao;

import com.community.entity.MenuDetail;
import com.community.entity.Older;
import com.community.entity.Page;
import com.community.entity.example.OlderExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OlderMapper {
    long countByExample(OlderExample example);

    int deleteByExample(OlderExample example);

    int insert(Older record);

    int insertSelective(Older record);

    List<Older> selectByExample(OlderExample example);

    int updateByExampleSelective(@Param("record") Older record, @Param("example") OlderExample example);

    int updateByExample(@Param("record") Older record, @Param("example") OlderExample example);

    List<Older> selectByActivity(@Param("noticeId") String noticeId, @Param("userId") String userId);

    List<Older> selectByFamily(@Param("familyId") String familyId);

    List<MenuDetail> selectByMenu(@Param("menuId") String menuId, @Param("page") Page page);

    Integer selectByMenuCount(@Param("menuId") String menuId);
}