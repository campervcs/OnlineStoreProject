package dao;

import models.customer.Cart;
import models.customer.Customer;
import models.product.Product;

import java.sql.SQLException;
import java.util.List;

public interface CartDAO {
    void updateCart(Customer customer) throws SQLException;
    List<Product> getProductList(int userid) throws SQLException;
}
