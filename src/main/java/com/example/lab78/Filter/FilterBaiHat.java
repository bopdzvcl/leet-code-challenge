package com.example.lab78.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(filterName = "??",value = "/song-management/*")
public class FilterBaiHat implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession ss = req.getSession();
        if(ss.getAttribute("tk")==null||ss.getAttribute("mk")==null){
            resp.sendRedirect("/dang-nhap");
        }else{
            filterChain.doFilter(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
