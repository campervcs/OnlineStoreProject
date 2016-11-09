package model;

import model.product.Product;
import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;

public class Purchase{
    private Product product;
    private int CustomerId;
    private DateTime date;

    public Purchase(Product product, int CustomerId, DateTime date) {
        this.CustomerId=CustomerId;
        this.date=date;
        this.product=product;
    }

    public Product getProduct(){
        return product;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public Long getDate() {
        return date.getMillis();
    }
}
