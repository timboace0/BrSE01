package bussiness.dao;

import bussiness.model.Student;
import utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao{
    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call = conn.prepareCall("{CALL get_all_students()}");

            ResultSet rs = call.executeQuery();
            while (rs.next()){
                Student s = new Student(
                        rs.getInt("student_id"),
                        rs.getString("full_name"),
                        rs.getDate("date_of_birth").toLocalDate(),
                        rs.getString("email")
                );

                students.add(s);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return students;
    }

    @Override
    public Student findStudentById(Integer id) {
        Connection conn = ConnectionDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{CALL find_student_by_id(?)}");
            call.setInt(1,id);

            ResultSet rs = call.executeQuery();
            while (rs.next()){
                Student s = new Student(
                        rs.getInt("student_id"),
                        rs.getString("full_name"),
                        rs.getDate("date_of_birth").toLocalDate(),
                        rs.getString("email")
                );
                return s;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return null;
    }

    @Override
    public void addStudent(Student student) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call = conn.prepareCall("{CALL add_student(?,?,?)}");
            call.setString(1,student.getFullName());
            call.setDate(2, Date.valueOf(student.getDob()));
            call.setString(3,student.getEmail());

            call.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void updateStudent(Student student) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call = conn.prepareCall("{CALL update_student(?,?,?,?)}");
            call.setString(2, student.getFullName());
            call.setDate(3,Date.valueOf(student.getDob()));
            call.setString(4,student.getEmail());
            call.setInt(1, student.getStudentId());

            call.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteStudentById(Integer id) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call = conn.prepareCall("{CALL delete_student(?)}");
            call.setInt(1,id);

            call.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
