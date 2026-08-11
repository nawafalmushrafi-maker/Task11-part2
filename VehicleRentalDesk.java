package org.example.OOPTraining.AnimalOOPDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class VehicleRentalDesk {
    static Scanner scanner = new Scanner(System.in);

    static List<Rentable> rentals = new ArrayList<>();

    public static void main(String[] args) {
        startProgram();
    }
    static void startProgram() {
        IO.println(" Single vehicle created at startup ");
        Car firstCar = new Car("OM-1234", 30.000, 3, 5);
        firstCar.printAllInfo();
        rentals.add(firstCar);
        boolean exit = false;
        while (!exit) {
            IO.println("\n RENTAL MENU ");
            IO.println("1. Add a car");
            IO.println("2. Add a motorbike");
            IO.println("3. Print everything on hire");
            IO.println("4. Show total income");
            IO.println("5. Exit");
            IO.println("Choose:");
            int choice = scanner.nextInt();



            // is
            scanner.nextLine();

            switch (choice) {
                case 1:
                    rentals.add(addCar());
                    IO.println("Added.");
                    break;
                case 2:
                    rentals.add(addMotorbike());
                    IO.println("Added.");
                    break;
                case 3:
                    printEverything();
                    break;
                case 4:
                    showTotalIncome();
                    break;
                case 5:
                    exit = true;
                    IO.println("Goodbye.");
                    break;
                default:
                    IO.println("Invalid choice.");
            }
        }
    }

    static Car addCar() {
        IO.println("Enter plate number:");
        String plateNumber = IO.readln();
        IO.println("Enter daily rate:");
        double dailyRate = scanner.nextDouble();
        scanner.nextLine();
        IO.println("Enter rental days:");
        int rentalDays = scanner.nextInt();
        scanner.nextLine();
        IO.println("Enter number of seats:");
        int seats = scanner.nextInt();
        scanner.nextLine();
        return new Car(
                plateNumber,
                dailyRate,
                rentalDays,
                seats
        );
    }

    static Motorbike addMotorbike() {
        IO.println("Enter plate number:");
        String plateNumber = IO.readln();
        IO.println("Enter daily rate:");
        double dailyRate = scanner.nextDouble();
        scanner.nextLine();
        IO.println("Enter rental days:");
        int rentalDays = scanner.nextInt();
        scanner.nextLine();
        IO.println("Enter engine size:");
        int engineSize = scanner.nextInt();
        scanner.nextLine();
        return new Motorbike(
                plateNumber,
                dailyRate,
                rentalDays,
                engineSize
        );
    }

    static void printEverything() {
        int number = 1;
        for (Rentable item : rentals) {
            IO.println(number + ".");
            item.printAllInfo();
            number++;
        }
    }

    static void showTotalIncome() {
        double total = 0;
        for (Rentable item : rentals) {
            total += item.costFor(
                    item.getRentalDays()
            );
        }
        IO.println(
                "Total income: " +
                        String.format("%.2f", total) +
                        " OMR"
        );
    }
}

