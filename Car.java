package org.example.OOPTraining.AnimalOOPDemo;

public class Car implements Rentable {

    private String plateNumber;
    private double dailyRate;
    private int rentalDays;
    private int seats;

    public Car(String plateNumber, double dailyRate,
               int rentalDays, int seats) {
        setPlateNumber(plateNumber);
        setDailyRate(dailyRate);
        setRentalDays(rentalDays);
        setSeats(seats);
    }
    @Override
    public String getPlateNumber() {
        return plateNumber;
    }
    public void setPlateNumber(String plateNumber) {
        if (plateNumber == null || plateNumber.trim().isEmpty()) {
            IO.println("Plate number is required.");
        } else {
            this.plateNumber = plateNumber;
        }
    }
    public double getDailyRate() {
        return dailyRate;
    }
    public void setDailyRate(double dailyRate) {
        if (dailyRate > 0 && dailyRate <= 200) {
            this.dailyRate = dailyRate;
        } else {
            IO.println(
                    "Daily rate must be above 0 and not more than 200."
            );
        }
    }
    public int getRentalDays() {
        return rentalDays;
    }
    public void setRentalDays(int rentalDays) {
        if (rentalDays >= 1 && rentalDays <= 30) {
            this.rentalDays = rentalDays;
        } else {
            IO.println("Rental days must be from 1 to 30.");
        }
    }
    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {

        if (seats >= 2 && seats <= 7) {
            this.seats = seats;
        } else {
            IO.println("Car seats must be from 2 to 7.");
        }
    }
    @Override
    public void printAllInfo() {
        IO.println(
                "[Car] " +
                        plateNumber +
                        " | " +
                        String.format("%.2f", dailyRate) +
                        " OMR/day | " +
                        rentalDays +
                        " days | " +
                        seats +
                        " seats"
        );
    }
    @Override
    public double costFor(int days) {
        return (dailyRate * days) + 5.000;
    }
}

