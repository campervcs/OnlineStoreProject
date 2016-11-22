package servlets;

import model.customer.Role;
import services.UserService;
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
        Customer customer = new Customer(mail,uname,DigestUtils.md5Hex(pass), Role.user);
        UserService user = new UserService();
        try {
            user.create(customer);
            resp.getWriter().write("Succeful create!");
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }
    }
}
