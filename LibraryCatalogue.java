package org.example.OOPTraining.AnimalOOPDemo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LibraryCatalogue {

    static Scanner scanner = new Scanner(System.in);

    static List<LibraryItem> catalogue = new ArrayList<>();
    public static void main(String[] args) {
        startProgram();
    }
    static void startProgram() {
        IO.println("Single item created at startup");
        Book firstBook = new Book("Clean Code", "Robert Martin", 464);
        firstBook.printAllInfo();
        catalogue.add(firstBook);
        boolean exit = false;
        while (exit == false) {
            IO.println("\n LIBRARY MENU");
            IO.println("1. Add book");
            IO.println("2. Add magazine");
            IO.println("3. Print all");
            IO.println("4. Count");
            IO.println("5. Exit");
            IO.println("Choose:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    catalogue.add(addBook());
                    IO.println("Added.");
                    break;
                case 2:
                    catalogue.add(addMagazine());
                    IO.println("Added.");
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    IO.println("Count: " + catalogue.size());
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
    static Book addBook() {
        IO.println("Enter title:");
        String title = IO.readln();
        IO.println("Enter author:");
        String author = IO.readln();
        IO.println("Enter pages:");
        int pages = scanner.nextInt();
        scanner.nextLine();
        return new Book(title, author, pages);
    }

    static Magazine addMagazine() {
        IO.println("Enter magazine name:");
        String name = IO.readln();
        IO.println("Enter issue number:");
        int issueNumber = scanner.nextInt();
        scanner.nextLine();

        IO.println("Enter month:");
        String month = IO.readln();
        return new Magazine(name, issueNumber, month);
    }

    static void printAll() {
        int number = 1;
        for (LibraryItem item : catalogue) {
            IO.println(number + ".");
            item.printAllInfo();
            number++;
        }
    }
}