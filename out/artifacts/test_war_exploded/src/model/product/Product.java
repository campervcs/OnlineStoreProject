package model.product;

public abstract class Product{
    protected String model;
    protected String description;
    protected float price;
    protected final long id;

    public Product(String model, String description, float price, long id) {
        this.model = model;
        this.description = description;
        this.price=price;
        this.id=id;
    }
}
