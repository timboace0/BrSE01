package ra.baitap101.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ra.baitap101.model.dto.request.EmployeeCreateDTO;
import ra.baitap101.model.dto.request.EmployeeUpdateDTO;
import ra.baitap101.model.entity.Employee;
import ra.baitap101.service.EmployeeService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @Valid @ModelAttribute EmployeeCreateDTO dto
    ) throws IOException {

        Employee employee = employeeService.createEmployee(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @Valid @ModelAttribute EmployeeUpdateDTO dto
    ) throws IOException {

        Employee employee = employeeService.updateEmployee(id, dto);

        return ResponseEntity.ok(employee);
    }

}