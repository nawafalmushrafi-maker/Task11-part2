package org.example.OOPTraining.AnimalOOPDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GymMembershipDesk {
    static Scanner scanner = new Scanner(System.in);
    static List<Payable> members = new ArrayList<>();

    public static void main(String[] args) {
        startProgram();
    }

    static void startProgram() {

        IO.println(" Single member created at startup ");

        MonthlyMember firstMember =
                new MonthlyMember("Ahmed", 25, 30.000, 1001);
        firstMember.printAllInfo();

        members.add(firstMember);
        boolean exit = false;
        while (!exit) {
            IO.println("\n GYM MENU ");
            IO.println("1. Add a monthly member");
            IO.println("2. Add a day-pass visitor");
            IO.println("3. Print all members");
            IO.println("4. Show total monthly income");
            IO.println("5. Search a member by name");
            IO.println("6. Exit");
            IO.println("Choose:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    members.add(addMonthlyMember());
                    IO.println("Added.");
                    break;
                case 2:
                    members.add(addDayPassVisitor());
                    IO.println("Added.");
                    break;
                case 3:
                    printAllMembers();
                    break;
                case 4:
                    showTotalIncome();
                    break;
                case 5:
                    searchMember();
                    break;
                case 6:
                    exit = true;
                    IO.println("Goodbye.");
                    break;
                default:
                    IO.println("Invalid choice.");
            }
        }
    }
    static MonthlyMember addMonthlyMember() {
        IO.println("Enter member name:");
        String name = IO.readln();
        IO.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        IO.println("Enter monthly fee:");
        double monthlyFee = scanner.nextDouble();
        scanner.nextLine();
        IO.println("Enter membership ID:");
        int membershipId = scanner.nextInt();
        scanner.nextLine();
        return new MonthlyMember(
                name,
                age,
                monthlyFee,
                membershipId
        );
    }
    static DayPassVisitor addDayPassVisitor() {
        IO.println("Enter visitor name:");
        String name = IO.readln();
        IO.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        IO.println("Enter price per visit:");
        double pricePerVisit = scanner.nextDouble();
        scanner.nextLine();
        IO.println("Enter number of visits:");
        int visits = scanner.nextInt();
        scanner.nextLine();
        IO.println("Enter membership ID:");
        int membershipId = scanner.nextInt();
        scanner.nextLine();
        return new DayPassVisitor(
                name,
                age,
                pricePerVisit,
                visits,
                membershipId
        );
    }
    static void printAllMembers() {
        int number = 1;
        for (Payable member : members) {
            IO.println(number + ".");
            member.printAllInfo();
            number++;
        }
    }
    static void showTotalIncome() {
        double total = 0;
        for (Payable member : members) {
            total += member.monthlyTotal();
        }
        IO.println(
                "Total monthly income: " +
                        String.format("%.2f", total) +
                        " OMR"
        );
    }
    static void searchMember() {
        IO.println("Enter name to search:");
        String searchName = IO.readln();
        boolean found = false;
        for (Payable member : members) {
            if (member.getName().equals(searchName)) {
                member.printAllInfo();
                found = true;
            }
        }
        if (!found) {
            IO.println("Member not found.");
        }
    }
}

