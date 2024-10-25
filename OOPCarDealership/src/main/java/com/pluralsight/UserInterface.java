package com.pluralsight;

import javax.crypto.Cipher;
import java.util.ArrayList;

public class UserInterface {
    private Dealership dealership;

    UserInterface(){
        this.dealership = DealershipFileManager.getDealership();
    }

    public void display(){
        System.out.println("---------------------------------------------------------");
        System.out.println("Welcome to the Object Oriented Dealership!");
        System.out.println("---------------------------------------------------------");

        System.out.println("1)Filter by price");
        System.out.println("2)Filter by make/model");
        System.out.println("3)Filter by year");
        System.out.println("4)Filter by color");
        System.out.println("5)Filter by mileage");
        System.out.println("6)Filter by vehicle type");
        System.out.println("7)View all vehicles");
        System.out.println("\n");

        short choice = Console.PromptForShort("Enter a selection: ");
        switch (choice){
            case 1 -> {
                int minRange = Console.PromptForInt("Enter a min range:");
                int maxRange = Console.PromptForInt("Enter a max range: ");
                displayFilters(dealership.getVehiclesByPrice(minRange,maxRange));
            }

            case 2 -> {
                String makeRange = Console.PromptForString("Enter a make:");
                String modelRange = Console.PromptForString("Enter a model: ");
                displayFilters(dealership.getVehiclesByMakeModel(makeRange,modelRange));
            }

            case 3 -> {
                int minYearRange = Console.PromptForInt("Enter a min year: ");
                int maxYearRange = Console.PromptForInt("Enter a max year: ");
                displayFilters(dealership.getVehiclesByYear(minYearRange,maxYearRange));
            }

            case 4 -> {
                String colorRange = Console.PromptForString("Enter a color: ");
                displayFilters(dealership.getVehiclesByColor(colorRange));
            }

            case 5 -> {
                int minMileageRange = Console.PromptForInt("Enter a min mileage: ");
                int maxMileageRange = Console.PromptForInt("Enter a max mileage: ");
                displayFilters(dealership.getVehiclesByMileage(minMileageRange,maxMileageRange));
            }

            case 6 -> {
                String vehicleTypeQuery = Console.PromptForString("Enter a vehicle type: ");
                displayFilters(dealership.getVehiclesByType(vehicleTypeQuery));
            }

            case 7 -> {
                displayFilters(dealership.getAllVehicles());
            }

        }


    }
    public void displayFilters(ArrayList<Vehicle> inventory){
        System.out.printf("%5s|%5s|%5s|%5s|%5s|%5s|%5s|%5s\n","vin","year","make","model","vehicle-type","color","odometer","price");
        System.out.println("-------------------------------------------------------");
        for (Vehicle v: inventory){
            System.out.println(v.toString());
        }
    }
}
