package controller;

import model.Customer;

public interface UserControllerDAO {
    String showUsers();
    void create(Customer customer);
    void update(Customer customer);
    void delete(String userName);
}
