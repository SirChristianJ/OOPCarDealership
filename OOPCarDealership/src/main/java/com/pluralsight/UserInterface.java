package com.pluralsight;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class UserInterface {
    private Dealership dealership;

    UserInterface(){
        this.dealership = DealershipFileManager.getDealership();
    }

    public void display(){
        do {
            System.out.println("---------------------------------------------");
            System.out.println("Welcome to the Object Oriented Dealership!");
            System.out.println("---------------------------------------------");

            System.out.println("1)Filter by price");
            System.out.println("2)Filter by make/model");
            System.out.println("3)Filter by year");
            System.out.println("4)Filter by color");
            System.out.println("5)Filter by mileage");
            System.out.println("6)Filter by vehicle type");
            System.out.println("7)View all vehicles");
            System.out.println("8)Add vehicle");
            System.out.println("9)Remove vehicle");
            System.out.println("99)Exit");

            System.out.println("\n");

            try {
                short choice = Console.PromptForShort("Enter a selection: ");
                switch (choice) {
                    case 1 -> {
                        int minRange = Console.PromptForInt("Enter a min range:");
                        int maxRange = Console.PromptForInt("Enter a max range: ");
                        displayFilteredInventory(dealership.getVehiclesByPrice(minRange, maxRange));
                    }

                    case 2 -> {
                        String makeRange = Console.PromptForString("Enter a make:");
                        String modelRange = Console.PromptForString("Enter a model: ");
                        displayFilteredInventory(dealership.getVehiclesByMakeModel(makeRange, modelRange));
                    }

                    case 3 -> {
                        int minYearRange = Console.PromptForInt("Enter a min year: ");
                        int maxYearRange = Console.PromptForInt("Enter a max year: ");
                        displayFilteredInventory(dealership.getVehiclesByYear(minYearRange, maxYearRange));
                    }

                    case 4 -> {
                        String colorRange = Console.PromptForString("Enter a color: ");
                        displayFilteredInventory(dealership.getVehiclesByColor(colorRange));
                    }

                    case 5 -> {
                        int minMileageRange = Console.PromptForInt("Enter a min mileage: ");
                        int maxMileageRange = Console.PromptForInt("Enter a max mileage: ");
                        displayFilteredInventory(dealership.getVehiclesByMileage(minMileageRange, maxMileageRange));
                    }

                    case 6 -> {
                        String vehicleTypeQuery = Console.PromptForString("Enter a vehicle type: ");
                        displayFilteredInventory(dealership.getVehiclesByType(vehicleTypeQuery));
                    }

                    case 7 -> {
                        displayInventoryByVinYearMakeModel(dealership.getAllVehicles());
                    }

                    case 8 -> {
                        addVehicle();
                    }

                    case 9 -> {promptForRemovingVehicle();}

                    case 99 -> {
                        System.out.println("Exiting ...");
                        return;
                    }

                    default -> {
                        System.out.println("Please enter one of the available selections!\n");
                    }
                }
            } catch (NumberFormatException e){
                System.out.println("Enter a numerical number!");
            }
            String keyPress = Console.PromptForString("\nPress any key to return to previous menu: ");

        }while (true);
    }

    public void addVehicle(){

        Vehicle newVehicle = promptForAddingVehicle();
        dealership.addVehicle(newVehicle);
    }

    public void displayInventoryByVinYearMakeModel(ArrayList<Vehicle> inventory){
        System.out.printf("%5s|%5s|%5s|%5s\n","vin","year","make","model");
        System.out.println("-----------------------------------------------");
        for (Vehicle v: inventory){
            System.out.println(v.toEncodedString());
        }
    }

    public void displayFilteredInventory(ArrayList<Vehicle> inventory){
        System.out.printf("%5s|%5s|%5s|%5s|%5s|%5s|%5s|%5s\n","vin","year","make","model","vehicle-type","color","odometer","price");
        System.out.println("-------------------------------------------------------");
        for (Vehicle v: inventory){
            System.out.println(v.toString());
        }
    }

    public Vehicle promptForAddingVehicle(){
        int vinToAdd = Console.PromptForInt("Add a vin: ");
        int yearToAdd = Console.PromptForInt("Add a year: ");
        String makeToAdd = Console.PromptForString("Add a make: ");
        String modelToAdd = Console.PromptForString("Add a model: ");
        String vehicleTypeToAdd = Console.PromptForString("What type of vehicle is this (truck,suv,van,etc): ");
        String colorToAdd = Console.PromptForString("What color is this vehicle: ");
        int odometerToAdd = Console.PromptForInt("Add odometer: ");
        double priceToAdd = Console.PromptForDouble("Add price: ");
        Vehicle vehicleToAdd = new Vehicle(vinToAdd,yearToAdd,makeToAdd,modelToAdd,vehicleTypeToAdd,colorToAdd,odometerToAdd,priceToAdd);

        return vehicleToAdd;
    }

    public void promptForRemovingVehicle(){
        int vinToRemove = Console.PromptForInt("Add a vin: ");
        dealership.removeVehicle(vinToRemove);
    }
}
