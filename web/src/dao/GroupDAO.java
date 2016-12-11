package dao;

import models.customer.Customer;
import models.customer.Group;

import java.sql.SQLException;
import java.util.List;

public interface GroupDAO {
    List<Customer> getUserList(int groupId) throws SQLException;
    List<Group> getGroupList() throws SQLException;
    void createGroup(String name,  int admin_id) throws SQLException;
    void deleteGroup(int groupID) throws SQLException;
    void joinGroup(int groupId, int customerId) throws SQLException;

}
