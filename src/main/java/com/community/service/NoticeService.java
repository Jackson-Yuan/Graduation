package com.community.service;

import com.community.dao.NoticeMapper;
import com.community.entity.Notice;
import com.community.entity.Page;
import com.community.entity.example.NoticeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by yyc on 2020/4/4.
 */
@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Transactional(rollbackForClassName = "{Exception.class}")
    public void insertNotice(Notice record) {
        Random random = new Random();
        String key = String.valueOf(System.currentTimeMillis()) + random.nextInt();
        record.setId(key);
        noticeMapper.insert(record);
    }

    /**
     * @Description: 分页查询, 需要根据是否参与来查询不同api
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @Transactional
    public Page<Notice> selectNoticeWithPage(Page<Notice> page, Date date, String userId, Boolean isParticipant) {
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        if (date != null) criteria.andStartDateGreaterThan(date);
        if (userId != null && !userId.isEmpty()) criteria.andUserIdEqualTo(userId);
        if (page.getPage() == null) {
            page.setPage(1);
            page.setRecord(4);
            Integer sum = 0;
            if (isParticipant) sum = noticeMapper.getCountWithParticipant(example);
            else sum = noticeMapper.getCountWithNotice(example);
            Integer sumPage = sum / page.getRecord();
            if (sum % page.getRecord() != 0) sumPage++;
            page.setSumPage(sumPage);
        }
        List<Notice> notices = null;
        if (isParticipant) notices = noticeMapper.selectByExampleAndParticipantWithPage(example, page);
        else notices = noticeMapper.selectByExampleWithPage(example, page);
        page.setRes(notices);
        return page;
    }

    public Notice getIndividualDetail(String noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }

    @Transactional(rollbackForClassName = "{Exception.class}")
    public void insertParticipant(String noticeId, String userId) {
        noticeMapper.insertParticipant(noticeId, userId);
    }

    /**
     * @Description: userId不为null或空串 代表删报名信息否则删活动信息
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @Transactional(rollbackForClassName = "{Exception.class")
    public void delete(String noticeId, String userId) {
        if (userId == null || userId.isEmpty()) noticeMapper.deleteByPrimaryKey(noticeId);
        else noticeMapper.deleteWithParticipant(noticeId, userId);
    }
}
