package lk.ijse.filter.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "C")
public class C implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter C Initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter C Do Filter Invoked : Before");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter C Do Filter Invoked : After");
    }

    @Override
    public void destroy() {
        System.out.println("Filter C Destroyed");
    }
}
