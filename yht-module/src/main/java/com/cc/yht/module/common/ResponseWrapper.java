package com.cc.yht.module.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrapper<T> {

    private Boolean success = true;
    private T result;
}
