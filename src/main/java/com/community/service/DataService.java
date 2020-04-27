package com.community.service;

import com.community.dao.BodyDataMapper;
import com.community.dao.EnvironmentDataMapper;
import com.community.dao.OlderMapper;
import com.community.entity.Older;
import com.community.entity.Page;
import com.community.entity.data.BodyData;
import com.community.entity.data.EnvironmentData;
import com.community.entity.example.BodyDataExample;
import com.community.entity.example.EnvironmentDataExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yyc on 2020/4/10.
 */
@Service
public class DataService {
    @Autowired
    private BodyDataMapper bodyDataMapper;

    @Autowired
    private EnvironmentDataMapper environmentDataMapper;

    @Autowired
    private OlderMapper olderMapper;

    public Page<BodyData> getBodyData(Page<BodyData> page, String familyId) {
        List<Older> olderList = olderMapper.selectByFamily(familyId);
        List<BodyData> dataList = new ArrayList<>();
        for (Older older : olderList) {
            BodyDataExample example = new BodyDataExample();
            example.or().andUserIdEqualTo(older.getUserId());
            example.setOrderByClause("`upload_date` DESC");
            Iterator<BodyData> cur = bodyDataMapper.queryWithPage(example, page).iterator();
            if (cur.hasNext()) {
                BodyData tmp = cur.next();
                tmp.setUserName(older.getUserName());
                dataList.add(tmp);
            }
        }
        page.setRes(dataList);
        return page;
    }

    public List<BodyData> getHistoryBodyData(String familyId, Date current) {
        List<Older> olderList = olderMapper.selectByFamily(familyId);
        List<BodyData> dataList = new ArrayList<>();
        for (Older older : olderList) {
            BodyDataExample example = new BodyDataExample();
            for (int i = 0; i < 7; ++i) {
                Date start = new Date(current.getYear(), current.getMonth(), current.getDate() - i, 0, 0, 0);
                Date end = new Date(current.getYear(), current.getMonth(), current.getDate() - i, 23, 59, 59);
                example.clear();
                example.or().andUserIdEqualTo(older.getUserId()).andUploadDateBetween(start, end);
                BodyData cur = bodyDataMapper.queryWithHistory(example);
                cur.setUploadDate(start);
                cur.setUserName(older.getUserName());
                dataList.add(cur);
            }
        }

        return dataList;
    }

    public Page<EnvironmentData> getEnvironmentData(Page<EnvironmentData> page, String familyId) {
        List<Older> olderList = olderMapper.selectByFamily(familyId);
        List<EnvironmentData> dataList = new ArrayList<>();
        for (Older older : olderList) {
            EnvironmentDataExample example = new EnvironmentDataExample();
            example.or().andUserIdEqualTo(older.getUserId());
            example.setOrderByClause("`upload_date` DESC");
            Iterator<EnvironmentData> cur = environmentDataMapper.queryWithPage(example, page).iterator();
            if (cur.hasNext()) {
                dataList.add(cur.next());
            }
        }
        page.setRes(dataList);
        return page;
    }
}
