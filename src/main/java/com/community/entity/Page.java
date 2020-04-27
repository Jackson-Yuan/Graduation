package com.community.entity;

/**
 * Created by yyc on 2020/4/5.
 */

import java.util.List;

/**
 * @Description: 分页用的page类
 * @Param:
 * @Return:
 * @Author: yyc
 */
public class Page<T> {
    private Integer page;

    private Integer sumPage;

    private Integer record;

    private List<T> res;

    public Page() {
    }

    public Page(Integer page, Integer sumPage, Integer record) {
        this.page = page;
        this.sumPage = sumPage;
        this.record = record;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSumPage() {
        return sumPage;
    }

    public void setSumPage(Integer sumPage) {
        this.sumPage = sumPage;
    }

    public Integer getRecord() {
        return record;
    }

    public void setRecord(Integer record) {
        this.record = record;
    }

    public List<T> getRes() {
        return res;
    }

    public void setRes(List<T> res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", sumPage=" + sumPage +
                ", record=" + record +
                ", res=" + res +
                '}';
    }
}
