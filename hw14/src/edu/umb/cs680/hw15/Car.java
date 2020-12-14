package edu.umb.cs680.hw15;

import java.util.ArrayList;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;
    private int dominate = 0;
    public Car(String make, String model, int mileage, int year,
               float price){
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }
    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public float getPrice() {
        return price;
    }

    public void setDominateCount(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (this.price <= car.getPrice() &&
                    this.year <= car.getYear() &&
                    this.mileage >= car.mileage) {
                if (this.price < car.getPrice() &&
                        this.year < car.getYear() &&
                        this.mileage > car.mileage) {
                    this.dominate++;
                }

            }
        }
    }

    public int getDominateCount(){
        return this.dominate;
    }

}