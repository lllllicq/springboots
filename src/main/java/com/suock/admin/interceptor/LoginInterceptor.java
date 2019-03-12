package com.suock.admin.interceptor;

import com.suock.admin.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //添加登陆拦截器
        if (request.getSession().getAttribute(WebSecurityConfig.SESSION_KEY) != null) {
            return true;
        }
        String url = "/";
        response.sendRedirect(url);
        return false;
    }
}
