package lk.ijse.dbcp.api.listeners;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context was created");

            ServletContext servletContext = servletContextEvent.getServletContext();
            BasicDataSource pool = new BasicDataSource();
            pool.setDriverClassName("com.mysql.jdbc.Driver");
            pool.setUrl("jdbc:mysql://localhost:3306/company");
            pool.setUsername("root");
            pool.setPassword("sanu1234");
            pool.setInitialSize(3);
            pool.setMaxTotal(3);
            servletContext.setAttribute("dbcp",pool);


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context Destroyed");
    }
}
