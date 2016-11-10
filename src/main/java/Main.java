import controller.UserController;
import model.Cart;
import model.Customer;
import model.Purchase;
import model.product.Phone;
import model.product.Product;
import org.joda.time.DateTime;
import view.UserView;


public class Main {
    public static void main(String args[])
    {
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
