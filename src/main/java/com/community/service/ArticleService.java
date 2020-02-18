package com.community.service;

import com.community.entity.Article;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yyc on 2020/2/18.
 */

/**
* @Description: 从网站抓取养生信息
* @Param: 
* @Return: 
* @Author: yyc
*/
@Service
public class ArticleService {
    private static final String prefix = "http://www.zhys.com";

    private static final String targetRegex =  "<li><a href=\"/zixun/[0-9]*.html\" target=\"_blank\"  title=\"[\\u4e00-\\u9fa5，：“”,]{0,}\"><i><img src=\"[a-z://0-9.]*\" alt=\"[\\u4e00-\\u9fa5，：“”,]{0,}\"></i></a>" +
            "<h5><a href=\"/zixun/[0-9]*.html\" title=\"[\\u4e00-\\u9fa5，：“”,]{0,}\"  target=\"_blank\">[\\u4e00-\\u9fa5，：“”,]{0,}</a></h5>" +
            "<span><b>[0-9]{4}-[0-9]{0,2}-[0-9]{0,2}</b>[\\u4e00-\\u9fa5，：“”,]{0,}</span></li>";

    private static final String titleRegex = "title=\"[\\u4e00-\\u9fa5，：“”,]{0,}\"";

    private static final String imageUrlRegex =  "src=\"[a-z:/0-9.]*\"";

    private static final String articleUrlRegex = "href=\"[a-z:/0-9.]*\"";


    public List<Article> getHealthMessage(){
        String url = prefix + "/zixun/";
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

            return getArticles(targetRegex, target);
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

        return null;

    }


    private List<Article> getArticles(String targetRegex, StringBuilder targetStr) {
        Pattern pattern = Pattern.compile(targetRegex);
        Matcher matcher = pattern.matcher(targetStr);

        List<Article> articles = new ArrayList<>();
        while (matcher.find()){
            StringBuilder str = new StringBuilder(matcher.group());
            Article article = new Article(getArticleProperty(titleRegex, str), getArticleProperty(imageUrlRegex, str),
                    getArticleProperty(articleUrlRegex, str));
            articles.add(article);
        }

        return articles;
    }

    private String getArticleProperty(String propertyRegex, StringBuilder targetStr){
        Pattern pattern =Pattern.compile(propertyRegex);
        Matcher matcher = pattern.matcher(targetStr);
        String res = null;
        String compare = propertyRegex.substring(0, propertyRegex.indexOf("="));
        if (matcher.find()){
            res = matcher.group();
            if ("title".equals(compare)) res = res.substring(7, res.length() - 1);
            else if ("src".equals(compare)) res = res.substring(5, res.length() - 1);
            else{
                res = res.substring(6, res.length() - 1);
                res = prefix + res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ArticleService().getHealthMessage());
    }
}
