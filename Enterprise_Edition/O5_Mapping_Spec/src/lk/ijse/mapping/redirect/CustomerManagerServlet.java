package lk.ijse.mapping.redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/customerManager")
public class CustomerManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        System.out.println("Customer Manager Get Request Received");
        resp.getWriter().write("Customer Manager Get Request Received");
//        resp.sendRedirect("itemManager");
        req.getRequestDispatcher("itemManager").forward(req,resp);
    }
}
