package org.example.OOPTraining.AnimalOOPDemo;

public class Service implements Sellable {

    private String name;
    private double price;
    private int minutes;

    public Service(String name, double price, int minutes) {
        setName(name);
        setPrice(price);
        setMinutes(minutes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            IO.println("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0 && price <= 10000) {
            this.price = price;
        } else {
            IO.println("Price out of range");
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes > 0) {
            this.minutes = minutes;
        } else {
            this.minutes = 0;
        }
    }

    @Override
    public void printAllInfo() {
        IO.println(
                "Service: " + name +
                        " | " + String.format("%.2f", price) +
                        " OMR | " + minutes + " min"
        );
    }

    @Override
    public String getCategory() {
        return "Service";
    }
}

