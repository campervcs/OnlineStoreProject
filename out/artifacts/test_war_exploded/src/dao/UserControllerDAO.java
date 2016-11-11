package dao;

import model.customer.Customer;

public interface UserControllerDAO {
    void showUsers();
    void create(Customer customer);
    void update(Customer customer);
    void delete(String userName);
}
