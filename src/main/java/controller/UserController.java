package controller;

import model.customer.Customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserController implements UserControllerDAO {
    @Override
    public String showUsers() {
        File file = new File("src/main/resources/users.txt");
        StringBuilder sb = new StringBuilder();

            try(BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()))) {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            catch(IOException e) {
                throw new RuntimeException(e);
            }
            return sb.toString();
    }

    @Override
    public void create(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(String userName) {

    }

}
