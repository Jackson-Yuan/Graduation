package com.community.service;

import com.community.dao.FamilyMapper;
import com.community.dao.OlderMapper;
import com.community.dao.UserMapper;
import com.community.entity.Family;
import com.community.entity.Older;
import com.community.entity.User;
import com.community.entity.example.FamilyExample;
import com.community.entity.example.OlderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

/**
 * Created by yyc on 2020/4/17.
 */
@Service
public class UserService {
    @Autowired
    private FamilyMapper familyMapper;

    @Autowired
    private OlderMapper olderMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackForClassName = "{Exception.class")
    public void insertOlderInfo(Older record) {
        olderMapper.insertSelective(record);
    }

    @Transactional(rollbackForClassName = "{Exception.class")
    public void updateOlderInfo(Older record, String editId) {
        OlderExample example = new OlderExample();
        example.or().andUserIdEqualTo(editId);
        olderMapper.updateByExampleSelective(record, example);
    }

    public Older getOlderInfo(String id) {
        OlderExample example = new OlderExample();
        example.or().andUserIdEqualTo(id);
        Iterator<Older> iterator = olderMapper.selectByExample(example).iterator();
        if (iterator.hasNext()) return iterator.next();
        else return null;
    }

    @Transactional(rollbackForClassName = "{Exception.class")
    public void insertFamilyInfo(Family record) {
        familyMapper.insertSelective(record);
    }

    @Transactional(rollbackForClassName = "{Exception.class")
    public void updateFamilyInfo(Family record, String editId) {
        FamilyExample example = new FamilyExample();
        example.or().andUserIdEqualTo(editId);
        familyMapper.updateByExampleSelective(record, example);
    }

    public Family getFamilyInfo(String id) {
        FamilyExample example = new FamilyExample();
        example.or().andUserIdEqualTo(id);
        Iterator<Family> iterator = familyMapper.selectByExample(example).iterator();
        if (iterator.hasNext()) return iterator.next();
        else return null;
    }

    public User getBaseInfo(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
