package servlets;

import models.customer.Customer;
import services.mySQLService.CartService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.SQLException;

public class CartListenerServlet extends HttpServlet
        implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        Customer user = (Customer)session.getAttribute("LOGIN_USER");
        try {
            (new CartService()).updateCart(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
