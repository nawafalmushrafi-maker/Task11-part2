package org.example.OOPTraining.AnimalOOPDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClinicWaitingList {
    static Scanner scanner = new Scanner(System.in);
    static List<Attendable> queue = new ArrayList<>();
    public static void main(String[] args) {
        startProgram();
    }
    static void startProgram() {
        IO.println(" Single item created at startup ");
        BookedPatient firstPatient =
                new BookedPatient("Sarah Bennett", 0, "09:30");
        firstPatient.setAge(150);
        firstPatient.printAllInfo();
        queue.add(firstPatient);
        boolean exit = false;
        while (exit == false) {
            IO.println("\n- CLINIC MENU ---");
            IO.println("1. Add booked");
            IO.println("2. Add walk-in");
            IO.println("3. Print queue");
            IO.println("4. Longest wait");
            IO.println("5. Exit");
            IO.println("Choose:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    queue.add(addBooked());
                    IO.println("Added.");
                    break;
                case 2:
                    queue.add(addWalkIn());
                    IO.println("Added.");
                    break;
                case 3:
                    printQueue();
                    break;
                case 4:
                    showLongestWait();
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
    static BookedPatient addBooked() {
        IO.println("Enter name:");
        String name = IO.readln();
        IO.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        IO.println("Enter slot time:");
        String slotTime = IO.readln();
        return new BookedPatient(name, age, slotTime);
    }
    static WalkInVisitor addWalkIn() {
        IO.println("Enter name:");
        String name = IO.readln();
        IO.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        IO.println("Enter arrival order:");
        int arrivalOrder = scanner.nextInt();
        scanner.nextLine();
        return new WalkInVisitor(name, age, arrivalOrder);
    }
    static void printQueue() {
        int number = 1;
        for (Attendable person : queue) {

            IO.println(number + ". " +
                    "[" + person.getPriority() + "]");
            person.printAllInfo();
            number++;
        }
    }
    static void showLongestWait() {
        Attendable longestWait = null;
        int longestMinutes = 0;
        for (Attendable person : queue) {
            if (person.getWaitMinutes() > longestMinutes) {
                longestMinutes = person.getWaitMinutes();
                longestWait = person;
            }
        }
        if (longestWait != null) {
            IO.println(
                    "Longest wait: " +
                            getPersonName(longestWait) +
                            " (" + longestMinutes + " min)"
            );
        }
    }
    static String getPersonName(Attendable person) {
        if (person instanceof BookedPatient) {
            return ((BookedPatient) person).getName();
        }
        return ((WalkInVisitor) person).getName();
    }
}

