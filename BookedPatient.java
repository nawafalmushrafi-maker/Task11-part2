package org.example.OOPTraining.AnimalOOPDemo;

public class BookedPatient implements Attendable {
    private String name;
    private int age;
    private String slotTime;
    public BookedPatient(String name, int age, String slotTime) {
        setName(name);
        setAge(age);
        this.slotTime = slotTime;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            IO.println("Name is required");
        } else {
            this.name = name;
        }
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            IO.println("Invalid age");
        }
    }
    public String getSlotTime() {
        return slotTime;
    }
    @Override
    public void printAllInfo() {
        IO.println(
                "[" + getPriority() + "] " +
                        name +
                        ", age " + age +
                        ", slot " + slotTime +
                        ", waits " + getWaitMinutes() + " min"
        );
    }
    @Override
    public String getPriority() {
        return "Booked";
    }
    @Override
    public int getWaitMinutes() {
        return 10;
    }
}

