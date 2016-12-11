package servlets;


import models.customer.Customer;
import services.mySQLService.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CreateGroup")
public class GroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/CreateGroup.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createGroup(req,resp);

    }
    private void createGroup(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        Customer user = (Customer) req.getSession().getAttribute("LOGIN_USER");
        try {
            GroupService service=new GroupService();
            service.createGroup(req.getParameter("groupName"),user.getId());
            resp.sendRedirect("/myStore");

        } catch (SQLException e) {
            resp.getWriter().write(e.getMessage());
        }
    }
}
