package bussiness.service;

import bussiness.dao.IStudentDao;
import bussiness.dao.StudentDaoImpl;
import bussiness.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private IStudentDao studentDao = new StudentDaoImpl();

    public void addStudents(Student student){
        studentDao.addStudent(student);
        System.out.println("Đã thêm sinh viên thành công!");
    }

    public void addStudents(List<Student> students){
        for (Student student : students){
            studentDao.addStudent(student);
        }
        System.out.println("Thêm sinh viên thành công!");
    }

    public void updateStudent(Student student){
        studentDao.updateStudent(student);
        System.out.println("Cập nhật sinh viên thành công!");
    }

    public int deleteStudentByAge(int id){
        return studentDao.deleteStudentsByAge(id);
    }


}
