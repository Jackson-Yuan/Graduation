package com.community.dao;

import com.community.entity.Menu;
import com.community.entity.example.MenuExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    String validateMenuByReservation(@Param("userId") String userId, @Param("menuId") String menuId);

    void deleteReservation(@Param("userId") String userId, @Param("menuId") String menuId);

    void insertReservation(@Param("userId") String userId, @Param("menuId") String menuId, @Param("content") String content);
}