package lk.ijse.filter.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/customer")
public class CustomerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Customer Filter Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1 Run before sending request to the servlet
        System.out.println("Before: Customer Filter Do filter method invoked");

        //Send request to servlet
        filterChain.doFilter(servletRequest,servletResponse);

        //Run after getting the output of the servlet
        System.out.println("After : Customer Filter Do filter method invoked");

    }

    @Override
    public void destroy() {
        System.out.println("Customer Filter Destroyed");
    }
}
