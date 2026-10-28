package ra.baitap101.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.baitap101.model.entity.Employee;
import ra.baitap101.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployee(){
        return new ResponseEntity<>(employeeService.findAllEmployee(), HttpStatus.OK);
    }
}
