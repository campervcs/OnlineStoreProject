package model.product;

public abstract class Product{
    protected String model;
    protected String description;

    public Product(String model, String description) {
        this.model = model;
        this.description = description;
    }
}
