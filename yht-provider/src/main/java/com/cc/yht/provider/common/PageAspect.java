package com.cc.yht.provider.common;

import com.github.pagehelper.PageHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 整合 PageHelper 分页
 * <br/>
 * 携带分页信息的类必须继承 PageBase 类
 * @see com.cc.yht.provider.common.PageBase
 * <br/>
 * 在要进行分页的方法上加上 @Page 注解
 * @see com.cc.yht.provider.common.Page
 */
@Aspect
@Component
public class PageAspect {

    @Pointcut("@annotation(com.cc.yht.provider.common.Page)")
    public void pointCut() { }

    @Before("pointCut()")
    public void doBefore(JoinPoint point) {
        Object[] methodArgs = point.getArgs();
        if (methodArgs != null) {
            Arrays.stream(methodArgs)
                    .filter(args -> args instanceof PageBase)
                    .findFirst()
                    .ifPresent(arg -> {
                        PageBase pageBase = (PageBase) arg;
                        // 启动 PageHelper 分页
                        PageHelper.startPage(pageBase.getPageNo(), pageBase.getPageSize());
                    });
        }
    }
}
