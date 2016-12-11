package services.mySQLService;


import dao.ProductDAO;
import models.product.Laptop;
import models.product.Product;
import models.product.ProductType;
import services.dbService.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ProductService implements ProductDAO {

    private List<Product> currentTypeProduct;
    private Connection connection = null;
    private Statement statement = null;
    private List<Product> allProducts = new LinkedList<>();

    private void getAllProducts() throws SQLException {
        allProducts.clear();
        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM product JOIN producttype " +
                    "ON product.typeId = producttype.idtype");
            while (res.next()) {
                Product product;
                switch (ProductType.valueOf(res.getString("typeName"))) {
                    case Laptop:
                        product = new Laptop(res.getString("model"),
                                res.getString("description"), res.getFloat("price"),
                                ProductType.Laptop);
                        product.setId(res.getInt("idproduct"));
                        allProducts.add(product);
                        break;
                    case Phone:
                        product = new Laptop(res.getString("model"),
                                res.getString("description"), res.getFloat("price"),
                                ProductType.Phone);
                        product.setId(res.getInt("idproduct"));
                        allProducts.add(product);
                        break;
                    case Tablet:
                        product = new Laptop(res.getString("model"),
                                res.getString("description"), res.getFloat("price"),
                                ProductType.Tablet);
                        product.setId(res.getInt("idproduct"));
                        allProducts.add(product);
                        break;
                    default:
                        break;
                }
            }
        }  finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public List<Product> getProductList() throws SQLException{
        if (allProducts.isEmpty()) getAllProducts();
        return allProducts;
    }

    @Override
    public List<Product> getCurrentTypeProduct() throws SQLException {
        return null;
    }

    @Override
    public Product getProduct(int id) throws SQLException {
        if(allProducts.isEmpty()) getAllProducts();
        for (Product product : allProducts) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    @Override
    public void create(Product product) throws SQLException {
        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO product (typeId, description, price, model) " +
                    "VALUES ((select idtype from producttype where typeName='"
                    + product.getType().toString() + "'),'" + product.getDescription()
                    + "'," + String.valueOf(product.getPrice()) + ",'" + product.getModel() + "')");
        }  finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        getAllProducts();
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(long id) throws Exception {

    }

}
