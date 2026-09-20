package bussiness.dao;

import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeProjectDaoImpl implements IEmployeeProjectDao {

    @Override
    public void assignEmployeeToProject(int employeeId, int projectId) {
        Connection conn = ConnectionDB.openConnection();

        try {
            conn.setAutoCommit(false);

            CallableStatement call = conn.prepareCall(
                    "{CALL assign_employee_to_project(?,?)}"
            );

            call.setInt(1, employeeId);
            call.setInt(2, projectId);

            call.executeUpdate();

            conn.commit();

            System.out.println("Gán nhân viên vào dự án thành công!");

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println(e.getMessage());

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}