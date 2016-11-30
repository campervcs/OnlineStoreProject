package models.product;

public class Laptop extends Product {
    private String cpu;
    private String graphicsCard;
    private String OS;
    private String resolution;
    private int cpu_core;
    private int cpu_rate;
    private int RAM;
    private int HDD;
    private int SSD;
    private int battery;
    private int USB_count;
    private boolean cd_dvd;

    public Laptop(String model, String description, float price, ProductType typeid) {
        super(model, description, price, typeid);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setCpu_core(int cpu_cores) {
        this.cpu_core = cpu_cores;
    }

    public void setCpu_rate(int cpu_rate) {
        this.cpu_rate = cpu_rate;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setHDD(int HDD) {
        this.HDD = HDD;
    }

    public void setSSD(int SSD) {
        this.SSD = SSD;
    }

    public void setUSB_count(int USB_count) {
        this.USB_count = USB_count;
    }

    public void setCd_dvd(boolean cd_dvd) {
        this.cd_dvd = cd_dvd;
    }


    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getCpu() {
        return cpu;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getOS() {
        return OS;
    }

    public String getResolution() {
        return resolution;
    }

    public int getCpu_core() {
        return cpu_core;
    }

    public int getCpu_rate() {
        return cpu_rate;
    }

    public int getRAM() {
        return RAM;
    }

    public int getHDD() {
        return HDD;
    }

    public int getSSD() {
        return SSD;
    }

    public int getUSB_count() {
        return USB_count;
    }

    public boolean isCd_dvd() {
        return cd_dvd;
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

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getBattery() {
        return battery;
    }

}
