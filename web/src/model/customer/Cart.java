package model.customer;

import model.product.Product;

import java.util.Stack;

//Singleton
public class Cart {
    private Stack<Product> cart = new Stack<Product>();
    public Product peekProduct() {
        return cart.peek();
    }
    public Product popProduct() {
        return cart.pop();
    }
    public void pushProduct(Product product) {
        cart.push(product);
    }
}
