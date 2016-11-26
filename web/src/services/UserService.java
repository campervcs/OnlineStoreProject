package services;

import dao.UserDAO;
import exceptions.CantFindUserException;
import exceptions.UserExistException;
import models.customer.Customer;
import models.customer.Role;

import java.sql.*;
import java.util.List;

public class UserService implements UserDAO {
    private final static String URL = "jdbc:mysql://localhost:3306/onlinestore";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    @Override
    public Customer getByUsernameAndPassword(String username, String password) throws Exception {
        Customer customer = null;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getDBConnection();
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM customer WHERE username = '" + username + "' AND password = '" + password + "'");
            while (res.next()) {
                customer = new Customer(res.getString("fname"),res.getString("lname"),res.getString("mail"), res.getString("username"), res.getString("password"), Role.valueOf(res.getString("role")), res.getString("adress"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
            if (customer == null) throw new CantFindUserException();
            else return customer;
    }
        @Override
        public List<Customer> getAllUsers () {
            return null;
        }

        @Override
        public void create (Customer customer) throws Exception {
            Connection connection = null;
            Statement statement = null;
            try {
                connection = getDBConnection();
                statement = connection.createStatement();
                ResultSet res = statement.executeQuery("SELECT username FROM customer WHERE username = '" + customer.getUsername() + "'");
                if(!res.next()) {
                    statement.executeUpdate("INSERT INTO customer (fname, lname, mail, username, password, role,adress) VALUES ('"+customer.getFname()+"','"+customer.getLname()+"','"+customer.getMail()+"','"+customer.getUsername()+"','"+customer.getPassword()+"','"+customer.getRole().toString()+"','"+customer.getAdress()+"')");
                }
                else throw new UserExistException();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            }
        }

        @Override
        public void update (Customer customer) throws SQLException {
            Connection connection = null;
            Statement statement = null;
            try {
                connection = getDBConnection();
                statement = connection.createStatement();
                    statement.executeUpdate("UPDATE customer SET fname ='"+customer.getFname()+"',lname='"+customer.getLname()+"', password='"+customer.getPassword()+"', adress='"+customer.getAdress()+"' WHERE username='"+customer.getUsername()+"'");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            }
        }


        private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
}
