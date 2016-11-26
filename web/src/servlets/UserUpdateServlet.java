package servlets;

import models.customer.Customer;
import models.customer.Role;
import org.apache.commons.codec.digest.DigestUtils;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlets.UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer currentUser = (Customer) req.getSession().getAttribute("LOGIN_USER");
        req.setAttribute("user", currentUser);
        if (currentUser!=null)
        req.getRequestDispatcher("/UserUpdate.jsp").forward(req, resp);
        else resp.sendRedirect("/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer currentUser = (Customer) req.getSession().getAttribute("LOGIN_USER");
        req.setAttribute("user", currentUser);
        String password = currentUser.getPassword();

        String pass = req.getParameter("password");
        String adress = req.getParameter("adress");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");

        currentUser.setFname(fname);
        currentUser.setLname(lname);
        if (!password.equals(pass)&&!pass.equals("")) currentUser.setPassword(DigestUtils.md5Hex(pass));
        currentUser.setAdress(adress);
        UserService userService = new UserService();
        try {
            userService.update(currentUser);
            req.getRequestDispatcher("/UserUpdate.jsp").forward(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("Problem with database");
        }
    }
}
