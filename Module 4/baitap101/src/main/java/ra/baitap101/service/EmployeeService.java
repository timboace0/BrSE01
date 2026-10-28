package ra.baitap101.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ra.baitap101.model.dto.request.RegisterRequest;
import ra.baitap101.model.entity.Employee;
import ra.baitap101.model.entity.User;
import ra.baitap101.repository.EmployeeRepository;
import ra.baitap101.repository.UserRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;



    public List<Employee> findAllEmployee(){
        return employeeRepository.findAllEmployee();
    }
}
