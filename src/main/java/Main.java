import model.Cart;
import model.product.Phone;
import model.product.Product;

public class Main {
    public static void main(String args[])
    {
        Product pr = new Phone("Nokia","nice phone");
        Product pr1 = new Phone("Nokia","nice phone");
        Cart cart = Cart.getInstance();
        cart.pushProduct(pr);
        cart.pushProduct(pr1);
        System.out.println(((Phone)cart.popProduct()).getID());
        System.out.println(((Phone)cart.popProduct()).getID());

    }
}
