package model.product;

public class Laptop extends Product {
    private String cpu;
    private String graphicsCard;
    private String OS;
    private String resolution;
    private static int id=0;
    private final int curID;
    private int cpu_cores;
    private int cpu_rate;
    private int RAM;
    private int HDD;
    private int SSD;
    private int USB_count;
    private boolean cd_dvd;

    public Laptop(String model, String description) {
        super(model, description);
        curID=id;
        id++;
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

    public void setCpu_cores(int cpu_cores) {
        this.cpu_cores = cpu_cores;
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



    public String getModel() {
        return model;
    }

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

    public int getCpu_cores() {
        return cpu_cores;
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

    public int getID() {
        return curID;
    }



}
