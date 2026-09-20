package bussiness.service;

import bussiness.dao.IStudentDao;
import bussiness.dao.StudentDaoImpl;
import bussiness.model.Course;
import bussiness.model.Grade;
import bussiness.model.Student;

import java.math.BigDecimal;
import java.util.List;

public class StudentManager {

    private IStudentDao studentDao = new StudentDaoImpl();

    public void addStudent(Student student) {
        if (student.getName() == null ||
                student.getName().trim().isEmpty()) {
            System.out.println("Tên sinh viên không được để trống!");
            return;
        }

        if (student.getEmail() == null ||
                student.getEmail().trim().isEmpty()) {
            System.out.println("Email không được để trống!");
            return;
        }

        studentDao.addStudent(student);
    }

    public void addCourse(Course course) {
        if (course.getTitle() == null ||
                course.getTitle().trim().isEmpty()) {
            System.out.println("Tên khóa học không được để trống!");
            return;
        }

        studentDao.addCourse(course);
    }

    public void updateGrades(int studentId, List<Grade> grades) {
        if (grades == null || grades.isEmpty()) {
            System.out.println("Danh sách điểm không được để trống!");
            return;
        }

        for (Grade grade : grades) {
            if (grade.getGrade() == null) {
                System.out.println("Điểm không được để trống!");
                return;
            }

            if (grade.getGrade().compareTo(BigDecimal.ZERO) < 0 ||
                    grade.getGrade().compareTo(BigDecimal.TEN) > 0) {
                System.out.println("Điểm phải từ 0 đến 10!");
                return;
            }
        }

        studentDao.updateGrades(studentId, grades);
    }

    public void listStudents() {
        List<Student> students = studentDao.listStudents();

        if (students.isEmpty()) {
            System.out.println("Không có sinh viên!");
            return;
        }

        System.out.println("""
                
                ========== DANH SÁCH SINH VIÊN ==========
                """);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}