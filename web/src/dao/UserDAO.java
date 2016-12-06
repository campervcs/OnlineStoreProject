package dao;

import exceptions.CantFindUserException;
import exceptions.UserExistException;
import models.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    Customer getByUsernameAndPassword(String username, String password) throws SQLException, CantFindUserException;
    List<Customer> getAllUsers() throws SQLException;
    void create(Customer customer) throws SQLException, UserExistException;
    void update(Customer customer) throws SQLException;
    void delete(Customer customer) throws SQLException;
}
