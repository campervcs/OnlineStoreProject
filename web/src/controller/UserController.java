package controller;

import dao.UserControllerDAO;
import model.customer.Customer;

public class UserController implements UserControllerDAO {
    @Override
    public void showUsers() {
        /*File file = new File("src/main/resources/users.txt");
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

            new UserView(sb.toString());*/
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
