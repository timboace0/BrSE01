package bussiness.model;

import java.math.BigDecimal;

public class Project {

    private int id;
    private String name;
    private BigDecimal budget;

    public Project() {
    }

    public Project(int id, String name, BigDecimal budget) {
        this.id = id;
        this.name = name;
        this.budget = budget;
    }

    public Project(String name, BigDecimal budget) {
        this.name = name;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return String.format(
                "Project ID: %-5d | Name: %-30s | Budget: %12.2f",
                id,
                name,
                budget
        );
    }
}