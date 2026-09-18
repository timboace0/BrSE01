package bussiness.dao;

import bussiness.model.Employee;
import bussiness.model.Project;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagementDaoImpl implements IManagementDao {

    @Override
    public boolean addEmployee(Employee employee) {

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL add_employee(?,?,?)}");

            call.setString(1, employee.getName());
            call.setString(2, employee.getDepartment());
            call.setBigDecimal(3, employee.getSalary());

            call.executeUpdate();

            return true;

        } catch (SQLException e) {

            if ("45000".equals(e.getSQLState())) {
                return false;
            }

            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean addProject(Project project) {

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL add_project(?,?)}");

            call.setString(1, project.getName());
            call.setBigDecimal(2, project.getBudget());

            call.executeUpdate();

            return true;

        } catch (SQLException e) {

            if ("45000".equals(e.getSQLState())) {
                return false;
            }

            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean assignEmployeeToProject(
            int employeeId,
            int projectId,
            String role
    ) {

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall(
                            "{CALL assign_employee_to_project(?,?,?)}"
                    );

            call.setInt(1, employeeId);
            call.setInt(2, projectId);
            call.setString(3, role);

            call.executeUpdate();

            return true;

        } catch (SQLException e) {

            if ("45000".equals(e.getSQLState())) {
                return false;
            }

            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void listEmployeesAndProjects() {

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall(
                            "{CALL list_employees_and_projects()}"
                    );

            ResultSet rs = call.executeQuery();

            while (rs.next()) {

                int employeeId =
                        rs.getInt("employee_id");

                String employeeName =
                        rs.getString("employee_name");

                String department =
                        rs.getString("department");

                String salary =
                        rs.getBigDecimal("salary").toString();

                String projectName =
                        rs.getString("project_name");

                String role =
                        rs.getString("role");

                if (projectName == null) {
                    projectName = "Chưa tham gia dự án";
                }

                if (role == null) {
                    role = "N/A";
                }

                System.out.printf(
                        "Employee ID: %-5d | Name: %-20s | Department: %-15s | Salary: %-12s | Project: %-25s | Role: %s%n",
                        employeeId,
                        employeeName,
                        department,
                        salary,
                        projectName,
                        role
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean updateEmployeeSalary(
            int employeeId,
            double newSalary
    ) {

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall(
                            "{CALL update_employee_salary(?,?)}"
                    );

            call.setInt(1, employeeId);
            call.setDouble(2, newSalary);

            call.executeUpdate();

            return true;

        } catch (SQLException e) {

            if ("45000".equals(e.getSQLState())) {
                return false;
            }

            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}