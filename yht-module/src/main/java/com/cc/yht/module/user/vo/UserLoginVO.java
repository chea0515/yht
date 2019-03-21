package com.cc.yht.module.user.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLoginVO {

    private Long userId;
    private String userName;
    private String userPassword;
    private Long telephone;
    private Date loginTime;
    private Integer status;
}
