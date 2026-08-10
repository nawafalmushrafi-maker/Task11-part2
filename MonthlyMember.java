package org.example.OOPTraining.AnimalOOPDemo;

public class MonthlyMember implements Payable {

    private String name;
    private int age;
    private double monthlyFee;
    private int membershipId;

    public MonthlyMember(String name, int age,
                         double monthlyFee, int membershipId) {
        setName(name);
        setAge(age);
        setMonthlyFee(monthlyFee);
        setMembershipId(membershipId);
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
    public double getMonthlyFee() {
        return monthlyFee;
    }
    public void setMonthlyFee(double monthlyFee) {
        if (monthlyFee > 0 && monthlyFee <= 500) {
            this.monthlyFee = monthlyFee;
        } else {
            IO.println(
                    "Monthly fee must be above 0 and not more than 500."
            );
        }
    }
    public int getMembershipId() {
        return membershipId;
    }
    public void setMembershipId(int membershipId) {
        if (membershipId > 0) {
            this.membershipId = membershipId;
        } else {
            IO.println("Membership ID must be above 0.");
        }
    }
    @Override
    public void printAllInfo() {
        IO.println(
                "[Monthly] " +
                        name +
                        " | age " +
                        age +
                        " | ID " +
                        membershipId +
                        " | fee " +
                        String.format("%.2f", monthlyFee) +
                        " OMR"
        );
    }
    @Override
    public double monthlyTotal() {

        return monthlyFee;
    }
}

