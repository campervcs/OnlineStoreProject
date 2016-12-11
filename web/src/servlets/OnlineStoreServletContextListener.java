package servlets;

import services.dbService.DBConnector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@WebListener
public class OnlineStoreServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection conn;
        Statement stmt;
        Properties property = new Properties();
        try(InputStream inputStream = OnlineStoreServletContextListener.class.getResourceAsStream("../resources/db_properties/MySQL_DB_Config")) {
            property.load(inputStream);
            String status = property.getProperty("Database.Status");
            if(status.equals("exist")) return;
        }catch (IOException s){
            System.out.println(s.getMessage());
        }
        try {
            conn = DBConnector.getDBConnection();
            stmt = conn.createStatement();
            String createTableCustomer_sql = "CREATE TABLE IF NOT EXISTS `customer` (" +
                    "  `idcustomer` INT(11) NOT NULL AUTO_INCREMENT," +
                    "  `fname` VARCHAR(45) DEFAULT NULL," +
                    "  `lname` VARCHAR(45) DEFAULT NULL," +
                    "  `mail` VARCHAR(45) NOT NULL," +
                    "  `username` VARCHAR(45) NOT NULL," +
                    "  `password` VARCHAR(100) NOT NULL," +
                    "  `role` VARCHAR(45) NOT NULL," +
                    "  `adress` VARCHAR(45) DEFAULT NULL," +
                    "  `ban` BINARY(1) DEFAULT '0'," +
                    "  PRIMARY KEY (`idcustomer`)," +
                    "  UNIQUE KEY `idcustomer_UNIQUE` (`idcustomer`)," +
                    "  UNIQUE KEY `username_UNIQUE` (`username`)" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;";
            String InsertToCustomer="INSERT INTO customer " +
                    "(username,`password`,role,mail) " +
                    "values('admin','21232f297a57a5a743894a0e4a801fc3','admin','admin@mail.ru');";
            String createTableProductType_sql = "CREATE TABLE IF NOT EXISTS `producttype` (" +
                    "  `idtype` INT(11) NOT NULL AUTO_INCREMENT," +
                    "  `typeName` VARCHAR(45) DEFAULT NULL," +
                    "  PRIMARY KEY (`idtype`)" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;";
            String InsertToProductType="INSERT INTO producttype" +
                    "(typeName)" +
                    "VALUES" +
                    "('Laptop'),('Phone'),('Tablet');";
            String createTableProduct_sql = "CREATE TABLE IF NOT EXISTS`product` (" +
                    "  `idproduct` INT(11) NOT NULL AUTO_INCREMENT," +
                    "  `typeId` INT(11) NOT NULL," +
                    "  `model` VARCHAR(45) NOT NULL," +
                    "  `description` VARCHAR(45) DEFAULT NULL," +
                    "  `price` FLOAT NOT NULL," +
                    "  `resolution` VARCHAR(45) DEFAULT NULL," +
                    "  `os` VARCHAR(45) DEFAULT NULL," +
                    "  `diagonal` INT(11) DEFAULT NULL," +
                    "  `camera_mp` INT(11) DEFAULT NULL," +
                    "  `cpu_core` INT(11) DEFAULT NULL," +
                    "  `cpu_rate` INT(11) DEFAULT NULL," +
                    "  `memmory` INT(11) DEFAULT NULL," +
                    "  `battery` INT(11) DEFAULT NULL," +
                    "  `ram` INT(11) DEFAULT NULL," +
                    "  `cpu` VARCHAR(45) DEFAULT NULL," +
                    "  `graphic_card` VARCHAR(45) DEFAULT NULL," +
                    "  `hdd` INT(11) DEFAULT NULL," +
                    "  `ssd` INT(11) DEFAULT NULL," +
                    "  `usb_count` INT(11) DEFAULT NULL," +
                    "  `cd_dvd` BIT(1) DEFAULT NULL," +
                    "  PRIMARY KEY (`idproduct`)," +
                    "  KEY `type_fk_idx` (`typeId`)," +
                    "  CONSTRAINT `type_fk` FOREIGN KEY (`typeId`) REFERENCES `producttype` (`idtype`) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8";
            String createTablePurchase_sql = "CREATE TABLE IF NOT EXISTS `purchase` (" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT," +
                    "  `customerId` INT(11) NOT NULL," +
                    "  `dateTime` DATE NOT NULL," +
                    "  `productId` INT(11) NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  UNIQUE KEY `id_UNIQUE` (`id`)," +
                    "  KEY `customer_fk_idx` (`customerId`)," +
                    "  KEY `product_fk_idx` (`productId`)," +
                    "  CONSTRAINT `customer_fk` FOREIGN KEY (`customerId`) REFERENCES `customer` (`idcustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION," +
                    "  CONSTRAINT `product_fk` FOREIGN KEY (`productId`) REFERENCES `product` (`idproduct`) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8";
            stmt.addBatch(createTableCustomer_sql);
            stmt.addBatch(createTableProductType_sql);
            stmt.addBatch(createTableProduct_sql);
            stmt.addBatch(createTablePurchase_sql);
            stmt.addBatch(InsertToCustomer);
            stmt.addBatch(InsertToProductType);
            stmt.executeBatch();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
