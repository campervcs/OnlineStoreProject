package dao;

import models.product.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    void create(Product product) throws Exception;
    void update(Product product);
    void delete(long id);
}
