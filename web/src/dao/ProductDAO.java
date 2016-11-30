package dao;

import models.product.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    List<Product> getCurrentTypeProduct() throws Exception;
    void create(Product product) throws SQLException;
    void update(Product product);
    void delete(long id) throws Exception;
}
