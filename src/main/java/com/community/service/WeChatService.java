package com.community.service;

import com.community.dao.UserMapper;
import com.community.entity.User;
import com.community.entity.example.UserExample;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yyc on 2020/3/18.
 */
@Service
public class WeChatService {
    private static final String appId = "wxce055fa581793a37";

    private static final String secret = "731475692988c840afc863c7dc5f4e77";

    @Autowired
    private UserMapper userMapper;

    /**
     * @Description: 根据前台的jsCode，获取OpenId
     * @Param:
     * @Return:
     * @Author: yyc
     */
    public String getOpenId(String jsCode) {
        String targetUrl = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" + appId +
                "&secret=" + secret +
                "&js_code=" + jsCode +
                "&grant_type=authorization_code";

        String res = null;
        try {
            URL url = new URL(targetUrl);
            /**获取HttpURRLConnection对象*/
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            /**调用connect方法连接远程资源*/
            connection.connect();
            /**访问资源数据，使用getInputStream方法获取一个输入流用以读取信息*/
            BufferedReader bReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "UTF-8"));

            /**访问数据*/
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            /**关闭资源*/
            bReader.close();
            connection.disconnect();
            res = stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    /**
     * @Description: 根据openId验证是否存在用户
     * @Param:
     * @Return:
     * @Author: yyc
     */
    public User getUserByOpenId(String openId) {
        UserExample example = new UserExample();
        example.or().andOpenIdEqualTo(openId);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0) {
            Iterator<User> iterator = users.iterator();
            return iterator.next();
        } else return null;
    }

    /**
     * @Description: 绑定微信的openId
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @Transactional(rollbackForClassName = {"Exception.class"})
    public User bindUserIdByOpenId(String userId, String openId, String password) {
        UserExample example = new UserExample();
        example.or().andUserIdEqualTo(userId);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0) {
            User user = users.iterator().next();
            password = new SimpleHash("MD5", password, userId).toString();
            if (password.equals(user.getPassword())) {
                User record = new User();
                record.setOpenId(openId);
                userMapper.updateByExampleSelective(record, example);
                user.setOpenId(openId);
                return user;
            } else return null;
        } else return null;
    }

    /**
     * @Description: 注册用户并绑定微信
     * @Param:
     * @Return:
     * @Author: yyc
     */
    @Transactional(rollbackForClassName = {"Exception.class"})
    public User registerUser(User record) {
        String password = new SimpleHash("MD5", record.getPassword(), record.getUserId()).toString();
        record.setPassword(password);
        userMapper.insert(record);
        return record;
    }
}
