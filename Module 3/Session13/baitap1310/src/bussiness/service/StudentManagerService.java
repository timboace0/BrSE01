package bussiness.service;

import bussiness.dao.IStudentManagerDao;
import bussiness.dao.StudentManagerDaoImpl;
import bussiness.model.Course;
import bussiness.model.Student;

public class StudentManagerService {

    static IStudentManagerDao iStudentManagerDao = new StudentManagerDaoImpl();

    public static void addStudent(Student student) {
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            System.out.println("Ten sinh vien khong duoc de trong");
            return;
        }

        if (student.getEmail() == null || student.getEmail().trim().isEmpty()) {
            System.out.println("Email khong duoc de trong");
            return;
        }

        if (!student.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            System.out.println("Email khong hop le");
            return;
        }

        boolean result = iStudentManagerDao.addStudent(student);

        if (result) {
            System.out.println("Them sinh vien thanh cong");
        }
    }

    public static void addCourse(Course course) {
        if (course.getTitle() == null || course.getTitle().trim().isEmpty()) {
            System.out.println("Ten khoa hoc khong duoc de trong");
            return;
        }

        if (course.getCredits() <= 0) {
            System.out.println("So tin chi phai lon hon 0");
            return;
        }

        boolean result = iStudentManagerDao.addCourse(course);

        if (result) {
            System.out.println("Them khoa hoc thanh cong");
        }
    }

    public static void enrollStudent(int studentId, int courseId) {
        if (studentId <= 0 || courseId <= 0) {
            System.out.println("ID khong hop le");
            return;
        }

        boolean result = iStudentManagerDao.enrollStudent(studentId, courseId);

        if (result) {
            System.out.println("Ghi danh thanh cong");
        }
    }

    public static void listStudentsAndGrades() {
        iStudentManagerDao.listStudentsAndGrades();
    }

    public static void updateStudentGrade(int studentId, int courseId, double grade) {
        if (studentId <= 0 || courseId <= 0) {
            System.out.println("ID khong hop le");
            return;
        }

        if (grade < 0 || grade > 10) {
            System.out.println("Diem phai tu 0 den 10");
            return;
        }

        boolean result = iStudentManagerDao.updateStudentGrade(
                studentId,
                courseId,
                grade
        );

        if (result) {
            System.out.println("Cap nhat diem thanh cong");
        }
    }
}