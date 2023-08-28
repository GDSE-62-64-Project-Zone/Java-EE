package lk.ijse.filter.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Default Filter Initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Before: Do filter Invoked");
        
        System.out.println("After: Do filter Invoked");
    }

    @Override
    public void destroy() {
        System.out.println("Default Filter Destroyed");
    }
}
