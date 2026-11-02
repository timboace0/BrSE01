package ra.baitap101.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ra.baitap101.cloudinary.CloudinaryService;
import ra.baitap101.model.dto.request.EmployeeCreateDTO;
import ra.baitap101.model.dto.request.EmployeeUpdateDTO;
import ra.baitap101.model.entity.Employee;
import ra.baitap101.repository.EmployeeRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CloudinaryService cloudinaryService;

    public Employee createEmployee(EmployeeCreateDTO dto) throws IOException {

        MultipartFile file = dto.getAvatarFile();

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Avatar file is required");
        }

        String avatarUrl = cloudinaryService.uploadImage(file);

        Employee employee = Employee.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .department(dto.getDepartment())
                .avatarUrl(avatarUrl)
                .build();

        return employeeRepository.save(employee);
    }


    public Employee updateEmployee(Long id, EmployeeUpdateDTO dto) throws IOException {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên"));

        employee.setFullName(dto.getFullName());
        employee.setEmail(dto.getEmail());

        if (dto.getAvatarFile() != null && !dto.getAvatarFile().isEmpty()) {
            String newAvatarUrl = cloudinaryService.uploadImage(dto.getAvatarFile());
            employee.setAvatarUrl(newAvatarUrl);
        }

        return employeeRepository.save(employee);
    }

}