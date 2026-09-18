package bussiness.dao;

import bussiness.model.Employee;
import bussiness.model.Project;

public interface IManagementDao {

    boolean addEmployee(Employee employee);

    boolean addProject(Project project);

    boolean assignEmployeeToProject(
            int employeeId,
            int projectId,
            String role
    );

    void listEmployeesAndProjects();

    boolean updateEmployeeSalary(
            int employeeId,
            double newSalary
    );
}