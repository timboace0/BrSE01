package ra.baitap81.repository;

import org.springframework.stereotype.Repository;
import ra.baitap81.exception.StudentNotFoundException;
import ra.baitap81.model.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepository{
    static List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1L,"Nguyễn Văn A"),
                    new Student(2L,"Nguyễn Văn B"),
                    new Student(3L,"Nguyễn Văn C")
            )
    );

    public Student findStudentById(Long id){
        return students.stream().filter(student -> Objects.equals(student.getId(), id)).findFirst().orElseThrow(() -> new StudentNotFoundException("Sinh viên không tồn tại!"));
    }
}
