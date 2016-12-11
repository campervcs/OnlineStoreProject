package services.dbService;

import services.mySQLService.ProductService;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
    public static Connection getDBConnection(){
        Properties property = new Properties();
        Connection dbConnection = null;
        try(InputStream inputStream = ProductService.class.getResourceAsStream("../../resources/db_properties/MySQL_DB_Config")) {
            property.load(inputStream);
            String URL = property.getProperty("Database.DataURL");
            String USERNAME = property.getProperty("Database.Prop.user");
            String PASSWORD = property.getProperty("Database.Prop.password");
            String DRIVER = property.getProperty("Database.Driver");
            Class.forName(DRIVER);
            dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException | IOException | SQLException e) {

            System.out.println(e.getMessage());

        }
        return dbConnection;
    }
}
