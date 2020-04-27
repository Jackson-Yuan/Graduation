package com.community.service;

import com.community.dao.MenuMapper;
import com.community.dao.OlderMapper;
import com.community.entity.Menu;
import com.community.entity.MenuDetail;
import com.community.entity.Page;
import com.community.entity.Result;
import com.community.entity.example.MenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by yyc on 2020/4/24.
 */
@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private OlderMapper olderMapper;

    @Transactional(rollbackForClassName = "{Exception.class}")
    public void insertMenu(Menu record) {
        record.setId(generateKey(record.getDate()));
        menuMapper.insert(record);
    }

    @Transactional(rollbackForClassName = "{Exception.class}")
    public void updateMenu(Menu record, String editId) {
        MenuExample example = new MenuExample();
        example.or().andIdEqualTo(editId);
        menuMapper.updateByExampleSelective(record, example);
    }

    public Menu getMenuInfo() {
        String id = generateKey(new Date());
        return menuMapper.selectByPrimaryKey(id);
    }

    public Result<Menu> validateReservation(String userId) {
        Result<Menu> result = new Result<>();
        String menuId = generateKey(new Date());
        Menu menu = menuMapper.selectByPrimaryKey(menuId);
        result.setData(menu);
        if (menu == null) {
            result.setMessage("error");
            result.setToken(false);
        } else {
            String content = menuMapper.validateMenuByReservation(userId, menuId);
            if (content != null) {
                result.setMessage(content);
                result.setToken(true);
            } else {
                result.setMessage("none");
                result.setToken(false);
            }
        }
        return result;
    }

    @Transactional(rollbackForClassName = "{Exception.class}")
    public void deleteReservation(String userId, String menuId) {
        menuMapper.deleteReservation(userId, menuId);
    }

    @Transactional(rollbackForClassName = "{Exception.class}")
    public void insertReservation(String userId, String menuId, String content) {
        menuMapper.insertReservation(userId, menuId, content);
    }

    public Page<MenuDetail> getReservation(Page<MenuDetail> page) {
        /**String id = generateKey(new Date());*/
        if (page.getPage() == null) {
            page.setPage(1);
            page.setRecord(4);
            Integer sum = olderMapper.selectByMenuCount("120324");
            if (sum % page.getRecord() != 0) {
                sum /= page.getRecord();
                ++sum;
            } else sum /= page.getRecord();
            page.setSumPage(sum);
        }
        List<MenuDetail> list = olderMapper.selectByMenu("120324", page);
        page.setRes(list);
        return page;
    }

    private String generateKey(Date date) {
        return String.valueOf(date.getYear()) + String.valueOf(date.getMonth()) + String.valueOf(date.getDate());
    }
}
