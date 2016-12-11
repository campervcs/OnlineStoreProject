package services.mySQLService;

import dao.UserDAO;
import exceptions.CantFindUserException;
import exceptions.UserExistException;
import models.customer.Customer;
import models.customer.Role;
import services.dbService.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UserService implements UserDAO {
    private Connection connection = null;
    private Statement statement = null;

    @Override
    public Customer getByUsernameAndPassword(String username, String password) throws SQLException,CantFindUserException {
        Customer customer = null;
        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM customer WHERE username = '"
                    + username + "' AND password = '" + password + "'");
            while (res.next()) {
                customer = new Customer(res.getString("fname"),
                        res.getString("lname"), res.getString("mail"), res.getString("username"),
                        res.getString("password"), Role.valueOf(res.getString("role")), res.getString("adress"),res.getBoolean("ban"));
                customer.setBan(res.getBoolean("ban"));
                customer.setId(res.getInt("idcustomer"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        if (customer == null) throw new CantFindUserException("Wrong username or password");
        else return customer;
    }

    @Override
    public List<Customer> getAllUsers() throws SQLException {
        List<Customer> userList = new LinkedList<>();
        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM customer");
            while (res.next()){
                Customer customer;
                userList.add(customer=new Customer(res.getString("fname"),res.getString("lname"),res.getString("mail"),res.getString("username"),res.getString("password"),Role.valueOf(res.getString("role")),res.getString("adress"),res.getBoolean("ban")));
                customer.setId(res.getInt("idcustomer"));
            }
            return userList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return userList;
    }

    @Override
    public void create(Customer customer) throws SQLException,UserExistException {
        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT username FROM customer " +
                    "WHERE username = '" + customer.getUsername() + "'");
            if (!res.next()) {
                statement.executeUpdate("INSERT INTO customer (fname, lname, mail, username, " +
                        "password, role,adress) VALUES ('" + customer.getFname() + "','" +
                        customer.getLname() + "','" + customer.getMail() + "','" +
                        customer.getUsername() + "','" + customer.getPassword() + "','" +
                        customer.getRole().toString() + "','" + customer.getAdress() + "')");
            } else throw new UserExistException("Username already exist",customer.getUsername());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public void update(Customer customer) throws SQLException {
        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE customer SET fname ='" + customer.getFname() +
                    "',lname='" + customer.getLname() + "', password='" +
                    customer.getPassword() + "', adress='" + customer.getAdress() +
                    "' WHERE username='" + customer.getUsername() + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public void delete(Customer customer) throws SQLException {

    }
}
