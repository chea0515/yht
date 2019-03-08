package com.cc.yht.provider.user.model;

import com.cc.yht.provider.common.BaseEntity;

public class User extends BaseEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
