package ra.baitap81.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.baitap81.model.entity.Student;
import ra.baitap81.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(
            @PathVariable(value = "id") Long id
    )  {
        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK);
    }
}
