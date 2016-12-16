package services.mySQLService;

import dao.CartDAO;
import models.customer.Customer;
import models.customer.Role;
import models.product.Product;
import services.dbService.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CartService implements CartDAO {
    private Connection connection = null;
    private Statement statement = null;

    @Override
    public void updateCart(Customer customer) throws SQLException {
        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();
            if (customer.getCart().getCartList().isEmpty())return;
            statement.addBatch("DELETE FROM cart WHERE customer_id ="+String.valueOf(customer.getId()));
            String insertCart = "INSERT INTO cart (product_id, customer_id, count) VALUES ";
            List<Product> productList = customer.getCart().getCartList();
            for (int i=0; i<productList.size(); i++){
                insertCart+="("+String.valueOf(productList.get(i).getId())+","+String.valueOf(customer.getId())+","+String.valueOf(productList.get(i).getCount())+")";
                if(i!=productList.size()-1) insertCart+=",";
            }
            statement.addBatch(insertCart);
            statement.executeBatch();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public List<Product> getProductList(int userid) throws SQLException {
        List<Product> productList = new LinkedList<>();
        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT product_id,count FROM cart WHERE customer_id = "+String.valueOf(userid));
            while (res.next()){
                Product p = (new ProductService()).getProduct(res.getInt("product_id"));
                p.setCount(res.getInt("count"));
                productList.add(p);
            }

            return productList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return productList;
    }
}
