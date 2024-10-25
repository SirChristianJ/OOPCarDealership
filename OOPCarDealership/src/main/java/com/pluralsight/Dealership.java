package com.pluralsight;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByPrice(int min, int max){
        ArrayList<Vehicle> priceRangeArray = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getPrice() >= min && v.getPrice() <= max){
                priceRangeArray.add(v);
            }
        }

        return priceRangeArray;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> makeModelRangeArray = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                makeModelRangeArray.add(v);
            }
        }

        return makeModelRangeArray;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> yearRangeArray = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getYear() >= min && v.getYear() <= max){
                yearRangeArray.add(v);
            }
        }

        return yearRangeArray;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> colorRangeArray = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                colorRangeArray.add(v);
            }
        }

        return colorRangeArray;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        ArrayList<Vehicle> milesRangeArray = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getOdometer() >= min && v.getOdometer() <= max){
                milesRangeArray.add(v);
            }
        }

        return milesRangeArray;
    }
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> vehiclesTypeArray = new ArrayList<>();
        for(Vehicle v: inventory){
            if(v.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehiclesTypeArray.add(v);
            }
        }

        return vehiclesTypeArray;
    }
    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }
    public void addVehicle(){
        try{
            int vinToAdd = Console.PromptForInt("Add a vin: ");
            int yearToAdd = Console.PromptForInt("Add a year: ");
            String makeToAdd = Console.PromptForString("Add a make: ");
            String modelToAdd = Console.PromptForString("Add a model: ");
            String vehicleTypeToAdd = Console.PromptForString("What type of vehicle is this (truck,suv,van,etc): ");
            String colorToAdd = Console.PromptForString("What color is this vehicle: ");
            int odometerToAdd = Console.PromptForInt("Add odometer: ");
            double priceToAdd = Console.PromptForDouble("Add price: ");

            Vehicle vehicleToAdd = new Vehicle(vinToAdd,yearToAdd,makeToAdd,modelToAdd,vehicleTypeToAdd,colorToAdd,odometerToAdd,priceToAdd);
            this.inventory.add(vehicleToAdd);
            DealershipFileManager.saveDealership(inventory);
        }catch(Exception e){e.getMessage();}
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public void setInventory(ArrayList<Vehicle> inventory){
        this.inventory = inventory;
    }
    @Override
    public String toString(){
        return String.format("%s|%s|%s\n", name,address,phone);
    }
}
