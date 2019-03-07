package com.cc.yht.provider.common;

import java.util.ArrayList;
import java.util.List;

public class PageInfo<T> {

    // 当前页
    private Integer pageNo;
    // 每页显示条数
    private Integer pageSize;
    // 总数
    private Integer totalCount;
    // 返回结果集
    private List<T> results;

    // 总页数
    private Integer totalPage;
    // 上一页
    private Integer prePage;
    // 下一页
    private Integer nextPage;


    public PageInfo() {
        new PageInfo<T>(new ArrayList<>());
    }

    public PageInfo(List<T> results) {
        com.github.pagehelper.PageInfo<T> pageHelperInfo =
                new com.github.pagehelper.PageInfo<>(results);
        this.pageNo = pageHelperInfo.getPageNum();
        this.pageSize = pageHelperInfo.getPageSize();
        this.totalCount = new Long(pageHelperInfo.getTotal()).intValue();
        this.results = results == null ? new ArrayList<>() : results;

        this.totalPage = pageHelperInfo.getPages();
        this.prePage = pageHelperInfo.getPrePage();
        this.nextPage = pageHelperInfo.getNextPage();
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public List<T> getResults() {
        return results;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }
}
