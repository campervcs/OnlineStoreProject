package controller;

import com.mysql.jdbc.Connection;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/controller.UserControllerServlet")
public class UserControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        resp.getWriter().write(uname +" "+ DigestUtils.md5Hex(pass));
    }
}
