import com.community.dao.BodyDataMapper;
import com.community.dao.EnvironmentDataMapper;
import com.community.entity.Page;
import com.community.entity.data.BodyData;
import com.community.entity.example.BodyDataExample;
import com.community.entity.example.EnvironmentDataExample;
import com.community.service.TryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by yyc on 2020/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml",
        "classpath:spring/spring-shiro.xml", "classpath:spring/spring-base.xml"})
public class DataTest {
    @Autowired
    private BodyDataMapper bodyDataMapper;

    @Autowired
    private EnvironmentDataMapper environmentDataMapper;

    @Autowired
    private TryService tryService;

    @Test
    public void testPage() {
        Page page = new Page();
        page.setPage(1);
        page.setRecord(1);
        EnvironmentDataExample example = new EnvironmentDataExample();
        example.or().andUserIdEqualTo("160310314");
        example.setOrderByClause("`upload_date` DESC");
        System.out.println(environmentDataMapper.queryWithPage(example, page));
    }

    @Test
    public void testHistory() {
        Date date = new Date();
        List<BodyData> history = new ArrayList<>();

        for (int i = 0; i < 7; ++i) {
            Date start = new Date(date.getYear(), date.getMonth(), date.getDate() + i, 0, 0, 0);
            Date end = new Date(date.getYear(), date.getMonth(), date.getDate() + i, 23, 59, 59);
            System.out.println(start + "   " + end);
            BodyDataExample example = new BodyDataExample();
            example.or().andUploadDateBetween(start, end).andUserIdEqualTo("160310314");
            BodyData tmp = bodyDataMapper.queryWithHistory(example);
            tmp.setUploadDate(start);
            history.add(tmp);
        }

        System.out.println(history);
    }

    @Test
    public void testInsert() {
        Date current = new Date();
        double[] blood = {97, 101, 102, 115, 116, 99, 106};
        double[] rate = {87, 66, 70, 88, 75, 66, 65};
        double[] temperature = {37.5, 36, 38.1, 38.5, 37.4, 37.6, 38};
        Random random = new Random();
        for (int i = 0; i < 7; ++i) {
            Date date = new Date(current.getYear(), current.getMonth(), current.getDate() - i, current.getHours(), current.getMinutes(), current.getSeconds());
            BodyData data = new BodyData("1002", blood[Math.abs(random.nextInt()) % 7], rate[Math.abs(random.nextInt()) % 7], temperature[Math.abs(random.nextInt()) % 7], date);
            bodyDataMapper.insertBodyDataInfo(data);
        }
    }

    @Test
    public void testBingFa1() throws InterruptedException {
        tryService.operation("1001", "gch");
    }

    @Test
    public void testBingFa2() throws InterruptedException {
        tryService.operation1("1001", "yyc");
    }
}
