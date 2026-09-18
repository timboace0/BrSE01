package bussiness.dao;

import bussiness.model.Course;
import bussiness.model.Student;

public interface IStudentManagerDao {
    boolean addStudent(Student student);
    boolean addCourse(Course course);
    boolean enrollStudent(int studentId, int courseId);
    void listStudentsAndGrades();
    boolean updateStudentGrade(int studentId, int courseId, double grade);
}