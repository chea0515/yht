package com.cc.yht.module.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YhtExceptions {

    public static YhtException getException(String code) {
        try {
            return (YhtException) Class.forName(
                    YhtExceptions.class.getCanonicalName() + "$" + code).newInstance();
        } catch (Exception ex) {
            log.error("[ YhtExceptions.getException ]", ex);
            return new YhtException("YhtExceptions.getException");
        }
    }

    public static class UserNotFound extends YhtException {
        public UserNotFound() {
            super("UserNotFound");
        }
    }
}
