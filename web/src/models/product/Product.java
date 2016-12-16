package models.product;

public abstract class Product{
    protected String model;
    protected String description;
    protected float price;
    protected ProductType typeid;
    protected int id;
    protected int count=1;


    public Product(String model, String description, float price, ProductType typeid) {
        this.model = model;
        this.description = description;
        this.price=price;
        this.typeid=typeid;
    }

    protected Product() {
    }

    public abstract ProductType getType();
    public abstract String getDescription();
    public abstract String getModel();
    public abstract float getPrice();
    public abstract int getId();
    public abstract void setId(int id);
    public abstract void setCount(int Count);
    public abstract int getCount();
}
