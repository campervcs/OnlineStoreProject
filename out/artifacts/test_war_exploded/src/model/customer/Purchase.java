package model.customer;

import model.product.Product;
import org.joda.time.DateTime;

public class Purchase{
    private Product product;
    private long CustomerId;
    private DateTime date;

    public Purchase(Product product, int CustomerId, DateTime date) {
        this.CustomerId=CustomerId;
        this.date=date;
        this.product=product;
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
}
