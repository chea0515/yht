package com.cc.yht.provider.common;


import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -4270031565428096655L;

    private Integer id;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private String version;

    public Integer getId() {
        return id;
    }

    public Integer getStatus() {
        return status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
