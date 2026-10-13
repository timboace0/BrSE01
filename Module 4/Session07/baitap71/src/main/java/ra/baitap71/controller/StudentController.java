package ra.baitap71.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.baitap71.model.dto.StudentDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @PostMapping
    public ResponseEntity<?> createStudent(
            @RequestBody @Valid StudentDTO studentDTO,
            BindingResult result
    ){
        if(result.hasErrors()){
            List<String> errors = result.getAllErrors()
                    .stream().map(ObjectError::getDefaultMessage)
                    .toList();

            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok("Thêm sinh viên thành công");
    }
}
