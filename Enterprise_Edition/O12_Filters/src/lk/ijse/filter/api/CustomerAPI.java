package lk.ijse.filter.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//http://localhost:8080/filter/customer
@WebServlet(urlPatterns = "/customer")
public class CustomerAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String test = (String) req.getAttribute("test");
//        System.out.println("Customer DO-Get Invoked "+test);
//        resp.addHeader("testing-header","Test-Header-FROM-Servlet");
        System.out.println("Request Received to the Servlet");
        resp.getWriter().write("<h1>Customer Servlet</h1>");
    }
}
