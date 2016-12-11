package servlets;

import services.mySQLService.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/myStore")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("PRODUCT_LIST", (new ProductService()).getProductList());
            req.getRequestDispatcher("views/welcome.jsp").forward(req, resp);
        } catch (SQLException e) {
            resp.getWriter().write(e.getMessage());
        }

    }
}
