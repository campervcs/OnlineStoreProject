import model.customer.Cart;
import model.customer.Customer;
import model.customer.Purchase;
import model.product.Phone;
import model.product.Product;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.joda.time.DateTime;
import view.UserView;


public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String args[])
    {
        PropertyConfigurator.configure("log4j.properties");
        LOGGER.info("Method is started");
        Product pr = new Phone("Nokia","nice phone");
        Product pr1 = new Phone("Nokia","nice phone");
        Cart cart = Cart.getInstance();
        Customer vanya = new Customer("vanya@mail.ru","123","admin");
        Purchase pur = new Purchase(pr,vanya.getID(),new DateTime());
        //System.out.println(pur.getDate());
        //cart.pushProduct(pr);
        //cart.pushProduct(pr1);
        UserView view = new UserView();

    }
}
