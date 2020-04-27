import com.community.dao.FeedbackMapper;
import com.community.dao.NoticeMapper;
import com.community.entity.Page;
import com.community.entity.example.FeedbackExample;
import com.community.entity.example.NoticeExample;
import com.community.service.NoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by yyc on 2020/4/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml",
        "classpath:spring/spring-shiro.xml", "classpath:spring/spring-base.xml"})
public class NoticeTest {
    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Test
    public void testPageSelect() {
        NoticeExample example = new NoticeExample();
        Date date = new Date(2019, 2, 20, 23, 0);
        Page page = new Page(null, null, null);
        NoticeExample.Criteria criteria = example.createCriteria();
        NoticeExample.Criteria criteria1 = example.createCriteria();
        criteria.andUserIdEqualTo("160310314");
        System.out.println(noticeService.selectNoticeWithPage(page, null, "160310314", true));
    }

    @Test
    public void testInsert() {
        noticeMapper.insertParticipant("1586154751079-1850416861", "160310314");
    }

    @Test
    public void testFeedBack() {
        Page page = new Page();
        page.setRecord(4);
        page.setPage(1);
        FeedbackExample example = new FeedbackExample();
        example.setOrderByClause("`date` DESC");
        System.out.println(feedbackMapper.selectByPage(example, page));
    }
}
