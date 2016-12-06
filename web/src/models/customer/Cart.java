package models.customer;

import models.product.Product;

import java.util.LinkedList;

public class Cart {
    private LinkedList<Product> cart = new LinkedList<>();
    public Product getProduct(int id) {
        for(Product product: cart){
            if (product.getId()==id) return product;
        }
        return null;
    }
    public Product popProduct() {
        return cart.pop();
    }
    public void pushProduct(Product product) {
        cart.push(product);
    }
}
