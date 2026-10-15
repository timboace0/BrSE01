package ra.baitap81.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.baitap81.model.entity.Student;
import ra.baitap81.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student findStudentById(Long id){
        return studentRepository.findStudentById(id);
    }
}
