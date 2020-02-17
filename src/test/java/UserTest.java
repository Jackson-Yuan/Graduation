import com.community.dao.UserMapper;
import com.community.entity.User;
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
        User user = new User("16031039", "ed1a1dd507f14da3dcddc92d61bf0671", "super_admin");
        userMapper.insert(user);
    }

    @Test
    public void generatePassword(){
        String str = "166322";

        String salt = "160310359";

        String res = new SimpleHash("MD5", str, salt).toString();

        System.out.println(res);
    }
}
