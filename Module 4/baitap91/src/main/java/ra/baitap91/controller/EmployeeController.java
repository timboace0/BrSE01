package ra.baitap91.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.baitap91.model.dto.request.DepartmentDTO;
import ra.baitap91.model.dto.request.EmployeeCreateDTO;
import ra.baitap91.model.dto.response.ApiResponse;
import ra.baitap91.model.entity.Department;
import ra.baitap91.model.entity.Employee;
import ra.baitap91.service.DepartmentService;
import ra.baitap91.service.EmployeeService;
import ra.baitap91.validator.CheckFileImage;

@RestController
@RequestMapping("/api/v1/employees")
@Validated
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(
            @Valid
            @RequestBody EmployeeCreateDTO employeeCreateDTO
    ) {
        return new ResponseEntity<>(employeeService.addEmployee(employeeCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ApiResponse<Employee> updateEmployee(
            @Valid
            @ModelAttribute EmployeeCreateDTO employeeCreateDTO,
            @PathVariable Long id
    ) {
        return ApiResponse.<Employee>builder()
                .status("SUCCESS")
                .message("Cập nhật nhân viên thành công!")
                .data(employeeService.updateEmployee(id,employeeCreateDTO))
                .build();
    }

    @PutMapping("/{id}/avatar")
    public ApiResponse<Employee> updateEmployeeAvatarUrl(
            @Valid
            @CheckFileImage
            @RequestParam("image") MultipartFile image,
            @PathVariable Long id
    ) {
        return ApiResponse.<Employee>builder()
                .status("SUCCESS")
                .message("Cập nhật avatar thành công!")
                .data(employeeService.updateEmployeeAvatarUrl(id,image))
                .build();
    }
}
