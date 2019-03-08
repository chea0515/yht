package com.cc.yht.provider.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * PageHelper 插件注解增强
 * @see com.github.pagehelper.PageHelper
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PageHelper {
    // no params
}
