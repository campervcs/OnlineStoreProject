package servlets;

import services.mySQLService.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AdminPanel")

public class AdminPanelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("USER_LIST", (new UserService()).getAllUsers());
            req.getRequestDispatcher("/views/adminPanel.jsp").forward(req, resp);
        } catch (SQLException e) {
            resp.getWriter().write(e.getMessage());
        }
    }
}
