package dao;

import models.product.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    List<Product> getProductList() throws SQLException;
    List<Product> getCurrentTypeProduct() throws SQLException;
    Product getProduct(int id) throws SQLException;
    void create(Product product) throws SQLException;
    void update(Product product);
    void delete(long id) throws Exception;
}
