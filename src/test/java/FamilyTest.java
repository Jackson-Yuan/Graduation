import com.community.dao.FamilyMapper;
import com.community.entity.Family;
import com.community.entity.example.FamilyExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yyc on 2020/3/31.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml",
        "classpath:spring/spring-shiro.xml", "classpath:spring/spring-base.xml"})
public class FamilyTest {
    @Autowired
    private FamilyMapper familyMapper;

    @Test
    public void testSelect() {
        FamilyExample example = new FamilyExample();
        example.or().andUserIdEqualTo("160310359");
        System.out.println(familyMapper.selectByExample(example));
    }

    @Test
    public void testUpdate() {
        FamilyExample example = new FamilyExample();
        example.or().andUserIdEqualTo("160310359");
        Family record = new Family();
        record.setUserName("袁庆");
        familyMapper.updateByExampleSelective(record, example);
    }
}
