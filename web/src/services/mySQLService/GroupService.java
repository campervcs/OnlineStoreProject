package services.mySQLService;

import dao.GroupDAO;
import models.customer.Customer;
import models.customer.Group;
import services.dbService.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupService implements GroupDAO {
    private Connection connection = null;
    private Statement statement = null;
    private List<Group> groupList = new ArrayList<>();

    @Override
    public List<Customer> getUserList(int groupId) throws SQLException {
        return null;
    }

    @Override
    public List<Group> getGroupList() throws SQLException {
        /*if(groupList.isEmpty()) selectAllFromGroup();*/
        return groupList;
    }

    private void selectAllFromGroup() throws SQLException{
       /* groupList.clear();
        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM `group`");
        }finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }*/
    }

    @Override
    public void createGroup(String name,  int admin_id) throws SQLException {
        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `group` (`name`, admin_id) " +
                    "VALUES ('"+name+"',"+admin_id+")");
        }  finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public void deleteGroup(int groupID) throws SQLException {

    }

    @Override
    public void joinGroup(int groupId, int customerId) throws SQLException {
        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();
            statement.addBatch("INSERT INTO group_customer (customer_id, group_id) " +
                    "VALUES ("+customerId+","+groupId+")");
            statement.addBatch("UPDATE `group` SET memberCount=(SELECT COUNT(customer_id) FROM group_customer JOIN `group` ON group_customer.group_id = `group`.idgroup)");
            statement.executeBatch();
        }  finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }
}
