package servlets;
import exceptions.CantFindUserException;
import exceptions.UserExistException;
import models.customer.Customer;
import services.mySQLService.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/servlets.AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/AuthorizationRegistration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        UserService service = new UserService();
        HttpSession session = req.getSession(true);
        try {
            Customer user= service.getByUsernameAndPassword(uname,DigestUtils.md5Hex(pass));
            if (!user.isBan()) {
                session.setAttribute("LOGIN_USER", user);
                resp.sendRedirect("/myStore");
            } else resp.sendRedirect("/login");

        } catch (SQLException | CantFindUserException e){
            resp.getWriter().write(e.getMessage());
        }

    }
}
