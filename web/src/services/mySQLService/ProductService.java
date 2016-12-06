package services.mySQLService;

import dao.ProductDAO;
import models.product.Product;

import java.sql.*;
import java.util.List;

public class ProductService implements ProductDAO {
    private final static String URL = "jdbc:mysql://localhost:3306/onlinestore";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private List<Product> allProducts;
    private List<Product> currentTypeProduct;
    private Connection connection = null;
    private Statement statement = null;

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getCurrentTypeProduct() throws Exception {
        return null;
    }

    @Override
    public void create(Product product) throws SQLException {
        try {
            connection = getDBConnection();
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO product (typeId, description, price, model) " +
                    "VALUES ((select idtype from producttype where typeName='"
                    + product.getType().toString() + "'),'" + product.getDescription()
                    + "',"+String.valueOf(product.getPrice())+",'" + product.getModel() + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(long id) throws Exception {

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
}
