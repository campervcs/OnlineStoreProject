package servlets;
import datasource.UserDBConnection;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/servlets.AuthoriztionServlet")
public class AuthoriztionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        UserDBConnection user = new UserDBConnection();
        try {
            user.getByUsernameAndPassword(uname,DigestUtils.md5Hex(pass));
            resp.sendRedirect("welcome.jsp");
        } catch (Exception e){
            resp.getWriter().write(e.getMessage());
        }

    }
}
