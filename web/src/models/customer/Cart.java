package models.customer;

import models.product.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart{


    private List<Product> cart = new ArrayList<>();

    public Cart() {
    }

    public List<Product> getCartList() {
        return cart;
    }

    public Product getProduct(int id) {
        for (Product product : cart) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    public void addProduct(Product product) {
        for (Product aCart : cart) {
            if (aCart.getId() == product.getId()) {
                aCart.setCount(aCart.getCount()+1);
                return;
            }
        }
        cart.add(product);
    }


    public void setCart(List<Product> cart) {
        this.cart = cart;
    }
}
