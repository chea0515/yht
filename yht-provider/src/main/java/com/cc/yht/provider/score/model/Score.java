package com.cc.yht.provider.score.model;

import com.cc.yht.provider.common.BaseEntity;

public class Score extends BaseEntity {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private Long score;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}