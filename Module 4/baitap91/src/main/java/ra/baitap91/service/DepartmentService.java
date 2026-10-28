package ra.baitap91.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.baitap91.model.dto.request.DepartmentDTO;
import ra.baitap91.model.entity.Department;
import ra.baitap91.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(DepartmentDTO departmentDTO){
        Department department = Department.builder()
                .name(departmentDTO.getName())
                .description(departmentDTO.getDescription())
                .build();

        return departmentRepository.save(department);
    }
}
