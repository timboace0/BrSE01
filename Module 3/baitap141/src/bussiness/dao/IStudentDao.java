package bussiness.dao;

import bussiness.model.Student;

public interface IStudentDao {
    void addStudent(Student student);

    void updateStudent(Student student);

    int deleteStudentsByAge(int id);
}
