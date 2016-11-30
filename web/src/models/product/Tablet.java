package models.product;

public class Tablet extends Product {
    private String resolution;
    private String OS;
    private int diagonal;
    private int camera_MP;
    private int cpu_core;
    private int cpu_rate;
    private int memmory;
    private int battery;
    private int RAM;
    private String cpu;

    public Tablet(String model, String description, float price, ProductType typeid) {
        super(model, description, price, typeid);
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setMemmory(int memmory) {
        this.memmory = memmory;
    }

    public void setCpu_rate(int cpu_rate) {
        this.cpu_rate = cpu_rate;
    }

    public void setCpu_core(int cpu_core) {
        this.cpu_core = cpu_core;
    }

    public void setCamera_MP(int camera_MP) {
        this.camera_MP = camera_MP;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public int getRAM() {
        return RAM;
    }

    public String getOS() {
        return OS;
    }

    @Override
    public String getModel() {
        return model;
    }

    public int getBattery() {
        return battery;
    }

    public int getMemmory() {
        return memmory;
    }

    public int getCpu_rate() {
        return cpu_rate;
    }

    public int getCpu_core() {
        return cpu_core;
    }

    public int getCamera_MP() {
        return camera_MP;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public String getResolution() {
        return resolution;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ProductType getType() {
        return typeid;
    }

    @Override
    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price=price;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpu() {
        return cpu;
    }
}
