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
    public void setInventory(ArrayList<Vehicle> inventory){
        this.inventory = inventory;
    }
    public void addVehicle(Vehicle v){
        try{

            this.inventory.add(v);
            DealershipFileManager.saveDealership(inventory);
        }catch(Exception e){e.getMessage();}
    }


    @Override
    public String toString(){
        return String.format("%s|%s|%s\n", name,address,phone);
    }
}
