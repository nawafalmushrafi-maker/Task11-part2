package org.example.OOPTraining.AnimalOOPDemo;

public class DayPassVisitor implements Payable {

    private String name;
    private int age;
    private double pricePerVisit;
    private int visits;
    private int membershipId;

    public DayPassVisitor(String name, int age,
                          double pricePerVisit,
                          int visits,
                          int membershipId) {
        setName(name);
        setAge(age);
        setPricePerVisit(pricePerVisit);
        setVisits(visits);
        if (membershipId > 0) {
            this.membershipId = membershipId;
        } else {
            IO.println("Membership ID must be above 0.");
            this.membershipId = 0;
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {

        if (name == null || name.trim().length() < 2) {
            IO.println("Member name must be at least 2 characters.");
        } else {
            this.name = name.trim();
        }
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < 14) {
            IO.println("Too young to register");
        } else if (age > 90) {
            IO.println("Age must be between 14 and 90.");
        } else {
            this.age = age;
        }
    }
    public double getPricePerVisit() {
        return pricePerVisit;
    }
    public void setPricePerVisit(double pricePerVisit) {
        if (pricePerVisit > 0) {
            this.pricePerVisit = pricePerVisit;
        } else {
            IO.println("Price per visit must be above 0.");
        }
    }
    public int getVisits() {
        return visits;
    }
    public void setVisits(int visits) {

        if (visits >= 1 && visits <= 31) {
            this.visits = visits;
        } else {
            IO.println("Visits must be from 1 to 31.");
        }
    }
    public int getMembershipId() {
        return membershipId;
    }
    @Override
    public void printAllInfo() {
        IO.println(
                "[Day Pass] " +
                        name +
                        " | age " +
                        age +
                        " | ID " +
                        membershipId +
                        " | " +
                        String.format("%.2f", pricePerVisit) +
                        " OMR/visit | " +
                        visits +
                        " visits"
        );
    }
    @Override
    public double monthlyTotal() {

        return pricePerVisit * visits;
    }
}

