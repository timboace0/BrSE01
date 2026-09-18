package bussiness.dao;

import bussiness.model.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> getAllStudent();
    Student findStudentById(Integer id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(Integer id);
}
