package bussiness.dao;

import bussiness.model.Course;
import bussiness.model.Student;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManagerDaoImpl implements IStudentManagerDao {

    @Override
    public boolean addStudent(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();

            callSt = conn.prepareCall("{call add_student(?, ?)}");

            callSt.setString(1, student.getName());
            callSt.setString(2, student.getEmail());

            callSt.execute();

            return true;
        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("Loi them sinh vien: " + e.getMessage());
            }
            return false;
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean addCourse(Course course) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();

            callSt = conn.prepareCall("{call add_course(?, ?)}");

            callSt.setString(1, course.getTitle());
            callSt.setInt(2, course.getCredits());

            callSt.execute();

            return true;
        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("Loi them khoa hoc: " + e.getMessage());
            }
            return false;
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean enrollStudent(int studentId, int courseId) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();

            callSt = conn.prepareCall("{call enroll_student(?, ?)}");

            callSt.setInt(1, studentId);
            callSt.setInt(2, courseId);

            callSt.execute();

            return true;
        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("Loi ghi danh: " + e.getMessage());
            }
            return false;
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void listStudentsAndGrades() {
        Connection conn = null;
        CallableStatement callSt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionDB.openConnection();

            callSt = conn.prepareCall("{call list_students_and_grades()}");

            rs = callSt.executeQuery();

            System.out.printf(
                    "%-5s %-25s %-30s %-10s %-25s %-10s%n",
                    "ID", "Student", "Email", "Course ID", "Course", "Grade"
            );

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                String email = rs.getString("email");
                int courseId = rs.getInt("course_id");
                String courseTitle = rs.getString("course_title");
                BigDecimal grade = rs.getBigDecimal("grade");

                String courseIdText = rs.wasNull()
                        ? "-"
                        : String.valueOf(courseId);

                String courseTitleText = courseTitle == null
                        ? "-"
                        : courseTitle;

                String gradeText = grade == null
                        ? "Chua co"
                        : grade.toString();

                System.out.printf(
                        "%-5d %-25s %-30s %-10s %-25s %-10s%n",
                        studentId,
                        studentName,
                        email,
                        courseIdText,
                        courseTitleText,
                        gradeText
                );
            }

        } catch (SQLException e) {
            System.out.println("Loi hien thi: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean updateStudentGrade(int studentId, int courseId, double grade) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();

            callSt = conn.prepareCall("{call update_student_grade(?, ?, ?)}");

            callSt.setInt(1, studentId);
            callSt.setInt(2, courseId);
            callSt.setDouble(3, grade);

            callSt.execute();

            return true;
        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("Loi cap nhat diem: " + e.getMessage());
            }
            return false;
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}