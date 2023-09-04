package lk.ijse.filter.filters;

import lk.ijse.filter.util.ResponseUtil;

import javax.json.JsonObject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Default Filter Initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Before: Do filter Invoked");
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        //we can check what is the HTTP method that the client
        //is using to request the servlet
        String method = req.getMethod();

        //Interrupt the request and check the Auth header with every request
        String auth = req.getHeader("Auth");

        //so, if the Auth header is present and username & password
        //are matching with every request then we can proceed the request
        //to relevant servlet
        if (auth != null && auth.equals("user=admin,pass=admins")) {
            //forward the request to the requested servlet
            filterChain.doFilter(servletRequest, servletResponse);

            //So, if the request is a preflight request (OPTION)
            if (method.equals("OPTIONS")){
                //we can append those headers to the response before it is
                //send back to the client
                res.setStatus(200);
                res.addHeader("Access-Control-Allow-Origin", "*");
                res.addHeader("Access-Control-Allow-Methods", "PUT, DELETE");
                res.addHeader("Access-Control-Allow-Headers", "content-type,auth");
            }else{
                //otherwise if it is a GET,POST,PUT or DELETE we can append the
                //following common header
                res.addHeader("Access-Control-Allow-Origin", "*");
            }
        } else {
            //otherwise send a json object that the clint is not allowed
            //to access the service
            res.addHeader("Content-Type", "application/json");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            JsonObject jsonObject = ResponseUtil.genJson("Auth-Error", "You are not Authenticated to use this Service.!");
            res.getWriter().print(jsonObject);
        }

        //if they are asking for preflight request then add those headers

        //add the cross-origin header
        System.out.println("After: Do filter Invoked");
    }

    @Override
    public void destroy() {
        System.out.println("Default Filter Destroyed");
    }
}
