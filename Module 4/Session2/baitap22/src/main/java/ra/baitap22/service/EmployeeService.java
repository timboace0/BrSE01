package ra.baitap22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.baitap22.model.entity.Employee;
import ra.baitap22.model.entity.EmployeeFilter;
import ra.baitap22.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.getAllEmp();
    }

    public Employee findById(int id){
        return employeeRepository.getEmpById(id);
    }

    public List<Employee> findByName(String name){
        return employeeRepository.getEmpByName(name);
    }

    public List<Employee> filterEmployees(EmployeeFilter filter) {
        return employeeRepository.filterEmployees(filter);
    }

    public void addEmp(Employee employee){
        employeeRepository.addEmp(employee);
    }

    public Employee updateEmp(int id, Employee employee){
        return employeeRepository.updateEmp(id, employee);
    }

    public boolean deleteEmp(int id) {
        return employeeRepository.deleteEmp(id);
    }
}
