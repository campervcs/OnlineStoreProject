package servlets;

import exceptions.CantFindUserException;
import models.customer.Cart;
import models.customer.Customer;
import models.product.Product;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import services.CartService;
import services.mySQLService.ProductService;
import services.mySQLService.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
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
            Customer user = service.getByUsernameAndPassword(uname, DigestUtils.md5Hex(pass));
            //Читаем корзину из куки
            Cookie[] cookies = req.getCookies();
            String cookieResult = "";
            for (Cookie cookie : cookies) {
                if (("Cart"+String.valueOf(user.getId())).equals(cookie.getName())) cookieResult = cookie.getValue();
            }
            user.setCart((Cart)CartService.fromString(cookieResult));

            if (!user.isBan()) {
                session.setAttribute("LOGIN_USER", user);
                resp.sendRedirect("/myStore");
            } else resp.sendRedirect("/login");

        } catch (SQLException | CantFindUserException e) {
            resp.getWriter().write(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
