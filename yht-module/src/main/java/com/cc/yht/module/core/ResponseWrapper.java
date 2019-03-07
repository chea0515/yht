package com.cc.yht.module.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseWrapper<T> {

    private Boolean success = true;
    private T result;
}
