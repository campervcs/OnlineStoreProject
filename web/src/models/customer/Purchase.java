package models.customer;

import models.product.Product;
import org.joda.time.DateTime;

public class Purchase{
    private Product product;
    private long CustomerId;
    private DateTime date;
    private final int id;

    public Purchase(Product product, int CustomerId, DateTime date, int id) {
        this.CustomerId=CustomerId;
        this.date=date;
        this.product=product;
        this.id=id;
    }

    public Product getProduct(){
        return product;
    }

    public long getCustomerId() {
        return CustomerId;
    }

    public Long getDate() {
        return date.getMillis();
    }

    public int getId() {
        return id;
    }
}
