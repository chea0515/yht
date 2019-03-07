package com.cc.yht.provider.common;

public class PageBase {

    private Integer pageNo;
    private Integer pageSize;
    private String order;
    private String orderBy;

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getOrder() {
        return order;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
