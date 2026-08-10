package org.example.OOPTraining.AnimalOOPDemo;

public class Magazine implements LibraryItem {

    private String name;
    private int issueNumber;
    private String month;
    public Magazine(String name, int issueNumber, String month) {
        setName(name);
        setIssueNumber(issueNumber);
        setMonth(month);
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
    public int getIssueNumber() {
        return issueNumber;
    }
    public void setIssueNumber(int issueNumber) {
        if (issueNumber >= 1 && issueNumber <= 500) {
            this.issueNumber = issueNumber;
        } else {
            IO.println("Invalid issue number.");
        }
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    @Override
    public void printAllInfo() {
        IO.println(
                "Magazine: " + name +
                        " | Issue " + issueNumber +
                        " | " + month +
                        " [" + getShelfCode() + "]"
        );
    }
    @Override
    public String getLabel() {
        return name;
    }
    @Override
    public String getShelfCode() {
        return "M-01";
    }
}

