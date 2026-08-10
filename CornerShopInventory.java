package org.example.OOPTraining.AnimalOOPDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CornerShopInventory {

    static Scanner scanner = new Scanner(System.in);
    static List<Sellable> stock = new ArrayList<>();
    public static void main(String[] args) {
        startProgram();
    }
    static void startProgram() {
        IO.println(" Single item created at startup ");
        Product firstProduct = new Product("Rice 5kg", -5, 12);
        firstProduct.printAllInfo();
        stock.add(firstProduct);
        boolean exit = false;
        while (exit == false) {
            IO.println("\n SHOP MENU ");
            IO.println("1. Add product");
            IO.println("2. Add service");
            IO.println("3. Print stock");
            IO.println("4. Total value");
            IO.println("5. Exit");
            IO.println("Choose:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    stock.add(addProduct());
                    IO.println("Added.");
                    break;
                case 2:
                    stock.add(addService());
                    IO.println("Added.");
                    break;
                case 3:
                    printStock();
                    break;
                case 4:
                    showTotalValue();
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
    static Product addProduct() {
        IO.println("Enter product name:");
        String name = IO.readln();
        IO.println("Enter price:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        IO.println("Enter quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        return new Product(name, price, quantity);
    }
    static Service addService() {
        IO.println("Enter service name:");
        String name = IO.readln();
        IO.println("Enter price:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        IO.println("Enter minutes:");
        int minutes = scanner.nextInt();
        scanner.nextLine();
        return new Service(name, price, minutes);
    }
    static void printStock() {
        int number = 1;
        for (Sellable item : stock) {
            IO.println(
                    number + ". [" +
                            item.getCategory() + "]"
            );

            item.printAllInfo();
            number++;
        }
    }
    static void showTotalValue() {
        double total = 0;
        for (Sellable item : stock) {
            total += item.getPrice();
        }
        IO.println(
                "Total value of stock: " +
                        String.format("%.2f", total) +
                        " OMR "
        );
    }
}
