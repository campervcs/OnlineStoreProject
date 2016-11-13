package dao;

import model.customer.Customer;

import java.util.List;

public interface UserDAO {
    Customer getByUsernameAndPassword(String username, String password) throws Exception;
    List<Customer> getAllUsers();
    void create(Customer customer) throws Exception;
    void update(Customer customer);
    void delete(String userName);
}
