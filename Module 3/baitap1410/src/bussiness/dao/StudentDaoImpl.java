package bussiness.dao;

import bussiness.model.Course;
import bussiness.model.Grade;
import bussiness.model.Student;
import utils.ConnectionDB;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {

    @Override
    public void addStudent(Student student) {
        Connection conn = ConnectionDB.openConnection();

        try {
            String checkSql = """
                    SELECT id
                    FROM student
                    WHERE email = ?
                    """;

            PreparedStatement check = conn.prepareStatement(checkSql);
            check.setString(1, student.getEmail());

            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                System.out.println("Sinh viên với email này đã tồn tại!");
                return;
            }

            String sql = """
                    INSERT INTO student(name, email)
                    VALUES (?, ?)
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());

            ps.executeUpdate();

            System.out.println("Thêm sinh viên thành công!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void addCourse(Course course) {
        Connection conn = ConnectionDB.openConnection();

        try {
            String checkSql = """
                    SELECT id
                    FROM course
                    WHERE title = ?
                    """;

            PreparedStatement check = conn.prepareStatement(checkSql);
            check.setString(1, course.getTitle());

            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                System.out.println("Khóa học này đã tồn tại!");
                return;
            }

            String sql = """
                    INSERT INTO course(title)
                    VALUES (?)
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, course.getTitle());

            ps.executeUpdate();

            System.out.println("Thêm khóa học thành công!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void updateGrades(int studentId, List<Grade> grades) {
        Connection conn = ConnectionDB.openConnection();

        try {
            conn.setAutoCommit(false);

            String checkStudentSql = """
                SELECT id
                FROM student
                WHERE id = ?
                """;

            PreparedStatement checkStudent =
                    conn.prepareStatement(checkStudentSql);

            checkStudent.setInt(1, studentId);

            ResultSet studentResult = checkStudent.executeQuery();

            if (!studentResult.next()) {
                throw new RuntimeException("Sinh viên không tồn tại!");
            }

            String checkCourseSql = """
                SELECT id
                FROM course
                WHERE id = ?
                """;

            String updateSql = """
                INSERT INTO enrollment(student_id, course_id, grade)
                VALUES (?, ?, ?)
                ON DUPLICATE KEY UPDATE grade = VALUES(grade)
                """;

            PreparedStatement checkCourse =
                    conn.prepareStatement(checkCourseSql);

            PreparedStatement update =
                    conn.prepareStatement(updateSql);

            for (Grade grade : grades) {

                if (grade.getGrade().compareTo(BigDecimal.ZERO) < 0 ||
                        grade.getGrade().compareTo(BigDecimal.TEN) > 0) {
                    throw new RuntimeException(
                            "Điểm phải nằm trong khoảng từ 0 đến 10!"
                    );
                }

                checkCourse.setInt(1, grade.getCourseId());

                ResultSet courseResult = checkCourse.executeQuery();

                if (!courseResult.next()) {
                    throw new RuntimeException(
                            "Khóa học ID " +
                                    grade.getCourseId() +
                                    " không tồn tại!"
                    );
                }

                update.setInt(1, studentId);
                update.setInt(2, grade.getCourseId());
                update.setBigDecimal(3, grade.getGrade());

                update.executeUpdate();
            }

            conn.commit();

            System.out.println("Cập nhật điểm thành công!");

        } catch (Exception e) {

            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println("Cập nhật điểm thất bại!");
            System.out.println(e.getMessage());

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Student> listStudents() {
        Connection conn = ConnectionDB.openConnection();

        List<Student> students = new ArrayList<>();

        try {
            String sql = """
                    SELECT id, name, email
                    FROM student
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );

                students.add(student);
            }

            return students;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}