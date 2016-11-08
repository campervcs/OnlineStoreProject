package model;

import model.product.Product;

import java.util.Stack;

//Singleton
public class Cart {
    private static Cart instance;
    private Cart(){}
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
    public static Cart getInstance() {
        if(instance==null) return instance=new Cart();
        else return null;
    }
}
