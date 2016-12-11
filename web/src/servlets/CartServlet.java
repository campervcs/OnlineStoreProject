package servlets;

import com.google.gson.Gson;
import models.customer.Cart;
import models.customer.Customer;
import models.product.Product;
import services.CartService;
import services.mySQLService.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("ProductId"));
        Customer user = (Customer) req.getSession().getAttribute("LOGIN_USER");
        try {
            user.getCart().addProduct((new ProductService()).getProduct(id));
            Cookie cookie = new Cookie("Cart"+String.valueOf(user.getId()), CartService.toString(user.getCart()));
            cookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(cookie);
            //Отвечаем на Ajax
                List<Product> products = user.getCart().getCartList();
                String json = new Gson().toJson(products);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
