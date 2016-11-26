package servlets;

import models.customer.Role;
import services.UserService;
import models.customer.Customer;
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
        String adress = req.getParameter("adress");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        Customer user = new Customer(fname,lname,mail,uname,DigestUtils.md5Hex(pass), Role.user,adress);
        UserService userService = new UserService();
        try {
            userService.create(user);
            resp.getWriter().write("Succeful create!");
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }
    }
}
