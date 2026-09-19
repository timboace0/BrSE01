package bussiness.model;

public class Subject {
    private String code;
    private String name;
    private int credits;
    private String startDate;

    public Subject(String code, String name, int credits, String startDate) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.startDate = startDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return String.format("Code: %-5s | Name: %-10s | Credits: %-2d | Start Date: %-10s",
                code,name,credits,startDate);
    }
}
