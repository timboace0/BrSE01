package ra.baitap22.model.entity;

public class EmployeeFilter {
    private String fullName;
    private String department;

    public EmployeeFilter(String fullName, String department) {
        this.fullName = fullName;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
