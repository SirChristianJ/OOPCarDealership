package com.pluralsight;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public Vehicle(int vinQuery){
            this.vin = vinQuery;
            this.year = getYear();
            this.make = getMake();
            this.model = getModel();
            this.vehicleType = getVehicleType();
            this.color = getColor();
            this.odometer = getOdometer();
            this.price = getPrice();
    }

    public int getVin() {
        return vin;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",vin,year,make,model,vehicleType,color,odometer,price);
    }

    public String toEncodedString() {
        return String.format("%d|%d|%s|%s\n",vin,year,make,model);
    }


}
