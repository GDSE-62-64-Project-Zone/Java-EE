package lk.ijse.filter.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "Filter1")
public class A implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter A Initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter A Do Filter Invoked : Before");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter A Do Filter Invoked: After");
    }

    @Override
    public void destroy() {
        System.out.println("Filter A Destroyed");
    }
}
