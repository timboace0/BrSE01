package bussiness.dao;

import bussiness.model.Course;
import bussiness.model.Grade;
import bussiness.model.Student;

import java.util.List;

public interface IStudentDao {
    void addStudent(Student student);
    void addCourse(Course course);
    void updateGrades(int studentId, List<Grade> grades);
    List<Student> listStudents();
}