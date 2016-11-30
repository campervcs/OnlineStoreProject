package models.product;

public abstract class Product{
    protected String model;
    protected String description;
    protected float price;
    protected ProductType typeid;

    public Product(String model, String description, float price, ProductType typeid) {
        this.model = model;
        this.description = description;
        this.price=price;
        this.typeid=typeid;
    }
    public abstract ProductType getType();
    public abstract String getDescription();
    public abstract String getModel();
    public abstract float getPrice();
}
