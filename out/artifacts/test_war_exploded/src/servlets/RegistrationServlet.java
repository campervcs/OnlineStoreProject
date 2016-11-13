package servlets;

import datasource.UserDBConnection;
import model.customer.Customer;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlets.RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mail = req.getParameter("mail");
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        Customer customer = new Customer(mail,uname,DigestUtils.md5Hex(pass),"user");
        UserDBConnection user = new UserDBConnection();
        try {
            user.create(customer);
            resp.getWriter().write(mail +" "+ uname +" "+ DigestUtils.md5Hex(pass));
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }
    }
}
