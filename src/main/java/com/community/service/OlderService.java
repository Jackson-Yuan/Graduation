package com.community.service;

import com.community.dao.OlderMapper;
import com.community.entity.Older;
import com.community.entity.example.OlderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by yyc on 2020/4/6.
 */
@Service
public class OlderService {
    @Autowired
    private OlderMapper olderMapper;

    public List<Older> getOldersByActivity(String noticeId, String userId) {
        return olderMapper.selectByActivity(noticeId, userId);
    }

    public List<Older> getOdersByFamily(String familyId) {
        return olderMapper.selectByFamily(familyId);
    }


    public Older getDetail(String userId) {
        OlderExample example = new OlderExample();
        example.or().andUserIdEqualTo(userId);
        List<Older> olders = olderMapper.selectByExample(example);
        Iterator<Older> iterator = olders.iterator();
        if (iterator.hasNext()) return iterator.next();
        else return null;
    }


}
