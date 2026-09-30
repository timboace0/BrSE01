package ra.baitap22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.baitap22.model.entity.Employee;
import ra.baitap22.model.entity.EmployeeFilter;
import ra.baitap22.service.EmployeeService;

import java.util.List;

@RequestMapping("/api/employees")
@RestController
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployee(){
        List<Employee> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        Employee emp = employeeService.findById(id);
        if(emp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getByName(@RequestParam("fullName") String name){
        List<Employee> emp = employeeService.findByName(name);
        if(emp.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterEmp(
            @ModelAttribute EmployeeFilter filter
            ) {
        List<Employee> employees = employeeService.filterEmployees(filter);

        if (employees.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<?> addEmp(
            @RequestBody Employee employee
    ) {
        employeeService.addEmp(employee);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmp(
            @PathVariable("id") int id,
            @RequestBody Employee employee
    ) {
        Employee updatedEmployee = employeeService.updateEmp(id, employee);

        if (updatedEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmp(@PathVariable("id") int id) {

        boolean deleted = employeeService.deleteEmp(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
