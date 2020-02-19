package com.community.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by yyc on 2020/2/19.
 */
@Service
public class LocateService {
    public static void main(String[] args) {
        String url = "https://api.map.baidu.com/location/ip?ak=i15oSW9QVItzj7dMAXId6Nc1gnmxBn0o&ip=192.168.0.106&coor=bd09ll";
        BufferedReader br = null;
        InputStream in = null;
        CharArrayWriter caw = null;
        InputStreamReader isr = null;

        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.connect();
            /**使用转换流，从网上爬的数据会乱码*/
            in = connection.getInputStream();
            isr = new InputStreamReader(in, "utf-8");
            br = new BufferedReader(isr);
            caw = new CharArrayWriter();
            char[] buffer = new char[1024];
            int len;
            while ((len = br.read(buffer)) != -1) {
                caw.write(buffer, 0, len);
            }
            StringBuilder target = new StringBuilder(caw.toString());
            System.out.println(target);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (caw != null) caw.close();
        }


    }
}
