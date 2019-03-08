package com.cc.yht.module.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YhtException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private String code = "400";
    private String msg;

    public YhtException() {
        super();
    }

    public YhtException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public YhtException(Throwable e) {
        super(e);
        this.msg = e.getMessage();
    }

    public YhtException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public YhtException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
