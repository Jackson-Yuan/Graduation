import com.community.controller.MenuController;
import com.community.controller.UserController;
import com.community.dao.MenuMapper;
import com.community.dao.OlderMapper;
import com.community.entity.MenuDetail;
import com.community.entity.Older;
import com.community.entity.Page;
import com.community.entity.example.OlderExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yyc on 2020/4/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml",
        "classpath:spring/spring-shiro.xml", "classpath:spring/spring-base.xml"})
public class OlderTest {
    @Autowired
    private OlderMapper olderMapper;

    @Autowired
    private UserController userController;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuController menuController;

    @Test
    public void testSelect() {
        System.out.println(olderMapper.selectByActivity("1586010792637-1493908873", null));
    }

    @Test
    public void testSelectById() {
        OlderExample example = new OlderExample();
        example.or().andUserIdEqualTo("160310368");
        System.out.println(olderMapper.selectByExample(example));
    }

    @Test
    public void testSelectByFamily() {
        System.out.println(olderMapper.selectByFamily("160310359"));
    }

    @Test
    public void testUpdate() {
        Older record = new Older();
        record.setUserName("周怡诚");
        record.setAddress("7-3202");
        record.setPhone("13901431268");
        userController.updateOlder(record, true, "160310355");
    }

    @Test
    public void testMenu() {
        System.out.println(menuMapper.validateMenuByReservation("160310314", "12032"));
    }

    @Test
    public void testMenuInfo() {
        Page<MenuDetail> page = new Page<>();
        System.out.println(menuController.getReservation(page));
    }
}
