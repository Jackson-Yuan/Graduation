package com.community.service;

import com.alibaba.fastjson.JSON;
import com.community.entity.Location;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by yyc on 2020/2/19.
 */
@Service
public class LocateService {
    private static String url = "https://api.map.baidu.com/location/ip?ak=i15oSW9QVItzj7dMAXId6Nc1gnmxBn0o&coor=bd09ll";

    public Location getLocation(String ipAddress) {
        url = generateTargetUrl(ipAddress);
        String json = generateJson();
        if (json != null) return JSON.parseObject(json, Location.class);
        else return null;
    }

    private String generateTargetUrl(String address){
        if (address != null) url = url + "&ip=" + address;
        return url;
    }

    private String generateJson(){
        BufferedReader br = null;
        InputStream in = null;
        InputStreamReader isr = null;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.connect();
            /**使用转换流，从网上爬的数据会乱码*/
            in = connection.getInputStream();
            isr = new InputStreamReader(in, "utf-8");
            br = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            String inputLine = null;
            while ((inputLine = br.readLine()) != null) {
                json.append(inputLine);
            }

            return json.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
