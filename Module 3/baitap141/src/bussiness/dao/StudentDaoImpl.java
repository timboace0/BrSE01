package bussiness.dao;

import bussiness.model.Student;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class StudentDaoImpl implements IStudentDao{
    @Override
    public void addStudent(Student student) {
        Connection conn = ConnectionDB.openConnection();
        try {
            conn.setAutoCommit(false);
            CallableStatement call = conn.prepareCall("{CALL add_students(?,?)}");

            call.setString(1, student.getName());
            call.setInt(2,student.getAge());

            call.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex){
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void updateStudent(Student student) {
        Connection conn = ConnectionDB.openConnection();
        try {
            conn.setAutoCommit(false);
            CallableStatement call = conn.prepareCall("{CALL update_student(?,?,?)}");
            call.setInt(1,student.getId());
            call.setString(2,student.getName());
            call.setInt(3,student.getAge());

            call.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }

    }

    @Override
    public int deleteStudentsByAge(int id) {
        Connection conn = ConnectionDB.openConnection();
        try {
            conn.setAutoCommit(false);
            CallableStatement call = conn.prepareCall("{CALL delete_students_by_age(?)}");
            call.setInt(1,id);

            int rows = call.executeUpdate();
            conn.commit();
            return rows;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }
}
