package ra.baitap91.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.baitap91.exception.DuplicateResourceException;
import ra.baitap91.exception.ResourceNotFoundException;
import ra.baitap91.model.dto.request.EmployeeCreateDTO;
import ra.baitap91.model.entity.Department;
import ra.baitap91.model.entity.Employee;
import ra.baitap91.repository.DepartmentRepository;
import ra.baitap91.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UploadService uploadService;

    public Employee addEmployee(EmployeeCreateDTO employeeCreateDTO){
        Department department = departmentRepository.findById(employeeCreateDTO.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Phòng ban không tồn tại!"));

        Boolean isEmailExisted = employeeRepository.existsByEmail(employeeCreateDTO.getEmail());
        if(isEmailExisted){
            throw new DuplicateResourceException("Email đã tồn tại");
        }

        Employee employee = Employee.builder()
                .fullName(employeeCreateDTO.getFullName())
                .email(employeeCreateDTO.getEmail())
                .phone(employeeCreateDTO.getPhone())
                .salary(employeeCreateDTO.getSalary())
                .department(department)
                .build();

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeCreateDTO employeeCreateDTO){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân viên!"));

        employee.setFullName(employeeCreateDTO.getFullName());
        employee.setEmail(employeeCreateDTO.getEmail());
        employee.setPhone(employeeCreateDTO.getPhone());
        employee.setSalary(employeeCreateDTO.getSalary());
        String newImageUrl = uploadService.uploadCloudinary(employeeCreateDTO.getAvatarUrl());
        employee.setAvatarUrl(newImageUrl);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeAvatarUrl(Long id, MultipartFile image){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân viên!"));
        String newImageUrl = uploadService.uploadCloudinary(image);
        employee.setAvatarUrl(newImageUrl);
        return employeeRepository.save(employee);
    }
}
