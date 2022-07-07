package com.leitianyu.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.leitianyu.reggie.common.BaseContext;
import com.leitianyu.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
检查用户是否完成登录
 */
@WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路径匹配器
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("拦截到请求:{}",request.getRequestURI());
        //1.获取本次请求URI
        String requestURI = request.getRequestURI();
        //放行路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**"
        };

        //2.判断本次请求是否需要处理,并通过
        Boolean check = check(urls, requestURI);
        if (check){
            filterChain.doFilter(request,response);
            return;
        }

        //3.判断用户是否完成登录
        if (request.getSession().getAttribute("employee")!=null) {
            Long employee = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(employee);
            filterChain.doFilter(request,response);
            return;
        }

        //4.未登录返回未登录结果，返回R对象

        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;

    }


    /*
    路径匹配，是否放行
     */
    public Boolean check(String[] stringsUri,String requestUri){
        for (String s : stringsUri) {
            boolean match = PATH_MATCHER.match(s, requestUri);
            if (match==true){
                return true;
            }
        }
        return false;
    }

}
