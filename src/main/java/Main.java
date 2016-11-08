import model.Cart;
import model.product.Phone;
import model.product.Product;

public class Main {
    public static void main(String args[])
    {
        Product pr = new Phone("Nokia","nice phone");
        Cart cart = Cart.getInstance();
        cart.pushProduct(pr);
        System.out.println(((Phone)cart.peekProduct()).getModel());

    }
}
