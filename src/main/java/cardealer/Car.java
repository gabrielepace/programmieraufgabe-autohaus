package cardealer;

import java.io.*;

public class Car implements Serializable{
    String ChassisNr;
    String brand;
    String model;
    int year;
    int km;
    float price;

    Car() {};

    public Car(String ChassisNr, String brand, String model, int year, int km, float price) {
        this.ChassisNr = ChassisNr;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.km = km;
        this.price = price;
    }

    public boolean addNewCar(String ChassisNr, String brand, String model, int year, int km, float price) {
        this.ChassisNr = ChassisNr;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.km = km;
        this.price = price;
        return true;
    }

    public String getChassisNr() {
        return ChassisNr;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getKm() {
        return km;
    }

    public float getPrice() {
        return price;
    }

    public void setChassisNr(String chassisNr) {
        ChassisNr = chassisNr;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
