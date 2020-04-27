package com.community.service;

import com.community.dao.TryMapper;
import com.community.entity.Try;
import com.community.entity.example.TryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yyc on 2020/4/24.
 */
@Service
public class TryService {
    @Autowired
    private TryMapper tryMapper;

    @Transactional
    public void updateContent(String id, String content) {
        TryExample example = new TryExample();
        example.or().andIdEqualTo(id);
        Try record = new Try();
        record.setContent(content);
        tryMapper.updateByExampleSelective(record, example);
    }

    @Transactional
    public void selectContent(String id) throws InterruptedException {
        Try cur = tryMapper.selectByPrimaryKey(id);
        System.out.println(cur.getContent());
        Thread.sleep(15 * 1000);
        Try next = tryMapper.selectByPrimaryKey(id);
        System.out.println(next.getContent());
    }

    @Transactional
    public void operation1(String id, String content) throws InterruptedException {
        TryExample example = new TryExample();
        example.or().andIdEqualTo(id);
        Try record = new Try();
        record.setContent(content);
        tryMapper.updateByExampleSelective(record, example);
        System.out.println(System.currentTimeMillis());
        Thread.sleep(15 * 1000);
        Try cur = tryMapper.selectByPrimaryKey(id);
        System.out.println(System.currentTimeMillis() + "------------->" + cur.getContent());
    }


    public void operation(String id, String content) {
        TryExample example = new TryExample();
        example.or().andIdEqualTo(id);
        Try record = new Try();
        record.setContent(content);
        tryMapper.updateByExampleSelective(record, example);
        System.out.println(System.currentTimeMillis());
    }
}
