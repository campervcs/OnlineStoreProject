package servlets;

import models.product.*;
import services.mySQLService.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/servlets.ProductCreateServlet")
public class ProductCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductType productType = models.product.ProductType.valueOf(req.getParameter("productType"));
        String description = req.getParameter("description");
        String model = req.getParameter("model");
        float price = Float.parseFloat(req.getParameter("price"));
        Product product;
        ProductService service = new ProductService();
        try {
            switch (productType) {
                case Laptop:
                    product = new Laptop(model, description, price, productType);
                    service.create(product);
                    break;
                case Phone:
                    product = new Phone(model, description, price, productType);
                    service.create(product);
                    break;
                case Tablet:
                    product = new Tablet(model, description, price, productType);
                    service.create(product);
                    break;
            }
        } catch (SQLException e) {
            resp.getWriter().write(e.getMessage());
        }
        resp.sendRedirect("/AdminPanel");
    }
}
