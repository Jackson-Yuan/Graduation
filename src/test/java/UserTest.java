import com.community.dao.UserMapper;
import com.community.entity.User;
import com.community.entity.example.UserExample;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yyc on 2020/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml",
        "classpath:spring/spring-shiro.xml", "classpath:spring/spring-base.xml"})
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        try {
            User record = new User("160310359", "166322", "visitor", "sdasdasd");
            userMapper.insert(record);
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }

    @Test
    public void generatePassword(){
        String str = "166322";

        String salt = "160310359";

        String res = new SimpleHash("MD5", str, salt).toString();

        System.out.println(res);
    }

    @Test
    public void testUpdate() {
        UserExample example = new UserExample();
        example.or().andUserIdEqualTo("160310359");
        User user = new User();
        user.setOpenId("oTT7y5ArOOZKF5p_UBXb5njmAmz8");
        userMapper.updateByExampleSelective(user, example);
    }


}
