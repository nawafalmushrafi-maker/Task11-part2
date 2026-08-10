package org.example.OOPTraining.AnimalOOPDemo;

public class Product implements Sellable {

    private String name;
    private double price;
    private int quantity;
    public Product(String name, double price, int quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        if (quantity >= 1 && quantity <= 100) {
            this.quantity = quantity;
        } else {
            IO.println("Quantity must be 1 to 100");
        }
    }
    @Override
    public void printAllInfo() {
        IO.println(
                "Product: " + name +
                        " | " + String.format("%.2f", price) +
                        " OMR | qty " + quantity
        );
    }
    @Override
    public String getCategory() {
        return "Product";
    }
}

