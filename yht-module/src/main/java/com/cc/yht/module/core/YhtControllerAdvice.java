package com.cc.yht.module.core;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class YhtControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Error exceptionHandler(Exception ex) {
        log.error("[ Exception ]", ex);
        Error err = new Error();
        err.setCode(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR));
        err.setMsg(ex.getMessage());
        return err;
    }

    @ResponseBody
    @ExceptionHandler(value = YhtException.class)
    public Error yhtExceptionHandler(YhtException ex) {
        log.error("[ YhtException ]", ex);
        Error err = new Error();
        err.setCode(ex.getCode());
        err.setMsg(ex.getMsg());
        return err;
    }

    @Getter
    @Setter
    private class Error {
        private String code;
        private String msg;
    }
}
