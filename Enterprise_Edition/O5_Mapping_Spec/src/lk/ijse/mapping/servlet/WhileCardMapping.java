package lk.ijse.mapping.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//if you wanted to map /all and then any path more path, then you can use while card mapping
//dall/jadijwij/jandjawd/jandjawnd/jndwajnjawd

@WebServlet(urlPatterns = "/all/*")
public class WhileCardMapping extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("While Card Mapping Invoked");
    }
}
