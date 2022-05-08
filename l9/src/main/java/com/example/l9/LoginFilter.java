package com.example.l9;

import com.example.l9.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginFilter implements Filter {
    private List<String> avoid_urls;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getServletPath();

        if (!avoid_urls.contains(url)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("current_user");
            if (user == null) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("login.jsp");
            } else
                filterChain.doFilter(servletRequest, servletResponse);
        } else
            filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        String urls = filterConfig.getInitParameter("avoid-urls");
        avoid_urls = Arrays.asList(urls.split(","));
    }
}
