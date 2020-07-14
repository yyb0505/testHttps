package com.yyb.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object uname = request.getSession().getAttribute("userInfo");
        String path = request.getServletPath();
        if (uname != null){
            return true;
        } else if(("/admin/admin").equals(path)){
            return true;
        } else if(("/admin/login").equals(path)){
            return true;
        } else if(("/admin/adminIndex").equals(path)){
            return true;
        }
        request.getRequestDispatcher("/admin/admin").forward(request,response);
        return  false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
