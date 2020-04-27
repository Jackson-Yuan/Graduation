package com.community.entity;

/**
 * Created by yyc on 2020/4/25.
 */
public class MenuDetail extends Older {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MenuDetail{" +
                "content='" + content + '\'' +
                '}';
    }
}
