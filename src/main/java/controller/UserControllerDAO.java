package controller;

import model.customer.Customer;

public interface UserControllerDAO {
    String showUsers();
    void create(Customer customer);
    void update(Customer customer);
    void delete(String userName);
}
