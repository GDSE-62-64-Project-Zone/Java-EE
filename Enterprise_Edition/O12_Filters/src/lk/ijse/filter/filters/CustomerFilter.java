package lk.ijse.filter.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/customers")
public class CustomerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Customer Filter Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1 Run before sending request to the servlet
        System.out.println("Before: Customer Filter Do filter method invoked");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        req.setAttribute("test","Set from Filter");

        String name = servletRequest.getParameter("name");
        if (name!=null && name.equals("iman")) {
            //Send request to servlet
            filterChain.doFilter(servletRequest,servletResponse);
            String header = resp.getHeader("testing-header");
            System.out.println(header);
        }else{
            resp.setStatus(500);
            resp.getWriter().write("User Not Available");
            System.out.println("Non Authenticated User");
        }

        //Run after getting the output of the servlet
        System.out.println("After : Customer Filter Do filter method invoked");

    }

    @Override
    public void destroy() {
        System.out.println("Customer Filter Destroyed");
    }
}
