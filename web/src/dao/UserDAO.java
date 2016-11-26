package dao;

import models.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    Customer getByUsernameAndPassword(String username, String password) throws Exception;
    List<Customer> getAllUsers();
    void create(Customer customer) throws Exception;
    void update(Customer customer) throws SQLException;
}
