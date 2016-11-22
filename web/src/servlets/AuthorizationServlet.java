package servlets;
import model.customer.Customer;
import services.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/servlets.AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        UserService user = new UserService();
        HttpSession session = req.getSession(true);
        try {
            Customer customer= user.getByUsernameAndPassword(uname,DigestUtils.md5Hex(pass));
            session.setAttribute("LOGIN_USER", customer);
            resp.sendRedirect("adminPanel.html");
        } catch (Exception e){
            resp.getWriter().write(e.getMessage());
        }

    }
}
