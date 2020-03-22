package com.community.service;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by yyc on 2020/3/18.
 */
@Service
public class WeChatService {
    private static final String appId = "wxce055fa581793a37";

    private static final String secret = "731475692988c840afc863c7dc5f4e77";

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
            res = JSON.toJSONString(stringBuilder);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
}
