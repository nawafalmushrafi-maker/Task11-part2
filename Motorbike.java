package org.example.OOPTraining.AnimalOOPDemo;

public class Motorbike implements Rentable {

    private String plateNumber;
    private double dailyRate;
    private int rentalDays;
    private int engineSize;
    public Motorbike(String plateNumber, double dailyRate,
                     int rentalDays, int engineSize) {
        setPlateNumber(plateNumber);
        setDailyRate(dailyRate);
        setRentalDays(rentalDays);
        setEngineSize(engineSize);
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
    public int getEngineSize() {
        return engineSize;
    }
    public void setEngineSize(int engineSize) {
        if (engineSize >= 50 && engineSize <= 1500) {
            this.engineSize = engineSize;
        } else {
            IO.println(
                    "Engine size must be from 50 to 1500 cc."
            );
        }
    }
    @Override
    public void printAllInfo() {
        IO.println(
                "[Motorbike] " +
                        plateNumber +
                        " | " +
                        String.format("%.2f", dailyRate) +
                        " OMR/day | " +
                        rentalDays +
                        " days | " +
                        engineSize +
                        " cc"
        );
    }
    @Override
    public double costFor(int days) {

        return dailyRate * days;
    }
}

