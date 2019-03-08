package com.cc.yht.module.common;

import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Object loginUserObj = request.getSession().getAttribute(Constants.USER_LOGO_SESSION);
        if (loginUserObj != null) {
            return true;
        } else {
            String httpMethod = request.getMethod();
            if (HttpMethod.GET.name().equals(httpMethod)) {
                response.sendRedirect("/yht");
            } else if (HttpMethod.POST.name().equals(httpMethod)) {
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.append("{\"code\":\"400\",\"msg\":\"no login\"}");
                writer.println();
                writer.close();
            }

            return false;
        }
    }
}
