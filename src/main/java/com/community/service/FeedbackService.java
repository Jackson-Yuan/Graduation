package com.community.service;

import com.community.dao.FeedbackMapper;
import com.community.entity.Feedback;
import com.community.entity.Page;
import com.community.entity.example.FeedbackExample;
import com.community.exception.ImageValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by yyc on 2020/4/8.
 */
@Service
public class FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;
    /**
     * 图片存储地址
     */
    private final static String targetPath = "../../img/";
    /**
     * 虚拟服务目录的获取地址
     */
    private final static String getPath = "/upLoadImg";

    public void insertImage(MultipartFile img, String feedbackId) throws IOException {
        String fileName = img.getOriginalFilename();
        String type = fileName.substring(fileName.lastIndexOf("."));
        /**校验文件是否为图片*/
        if (!(".jpg".equals(type) || ".png".equals(type))) throw new ImageValidateException("图片格式错误");
        String targetFileName = String.valueOf(System.currentTimeMillis()) + fileName;
        String path = targetPath + targetFileName;
        /**写入存储地址*/
        img.transferTo(new File(path));

        /**插入记录*/
        FeedbackExample example = new FeedbackExample();
        example.or().andIdEqualTo(feedbackId);
        Feedback record = new Feedback();
        record.setPictureUrl(getPath + targetFileName);
        feedbackMapper.updateByExampleSelective(record, example);
    }

    public void insertFeedback(Feedback feedback) {
        feedback.setId(generateKey(feedback));
        feedbackMapper.insertSelective(feedback);
    }

    private String generateKey(Feedback feedback) {
        return feedback.getUserId() + System.currentTimeMillis();
    }

    public Page<Feedback> queryWithPage(Page<Feedback> page) {
        FeedbackExample example = new FeedbackExample();
        if (page.getPage() == null) {
            page.setPage(1);
            page.setRecord(4);
            Integer sum = feedbackMapper.countByExample(example);
            if (sum % page.getRecord() != 0) {
                sum /= page.getRecord();
                ++sum;
            } else sum /= page.getRecord();
            page.setSumPage(sum);
        }
        example.setOrderByClause("`date` DESC");
        List<Feedback> list = feedbackMapper.selectByPage(example, page);
        page.setRes(list);
        return page;
    }

    public void deleteInfo(String id) {
        feedbackMapper.deleteByPrimaryKey(id);
    }


}
