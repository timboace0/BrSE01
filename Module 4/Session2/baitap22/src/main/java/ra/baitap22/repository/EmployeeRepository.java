package ra.baitap22.repository;

import org.springframework.stereotype.Repository;
import ra.baitap22.model.entity.Employee;
import ra.baitap22.model.entity.EmployeeFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>(
            List.of(
                    new Employee(1, "Nguyen Van An", "an@gmail.com", "IT"),
                    new Employee(2, "Tran Thi Binh", "binh@gmail.com", "HR"),
                    new Employee(3, "Le Van Cuong", "cuong@gmail.com", "Marketing"),
                    new Employee(4, "Pham Thi Dung", "dung@gmail.com", "Finance"),
                    new Employee(5, "Hoang Van Em", "em@gmail.com", "IT")
            )
    );

    public List<Employee> getAllEmp(){
        return employees;
    }

    public Employee getEmpById(int id){
        return employees.stream().filter(emp -> emp.getId() == id).findFirst().orElse(null);
    }

    public List<Employee> getEmpByName(String name){
        return employees.stream().filter(emp -> emp.getFullName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    public List<Employee> filterEmployees(EmployeeFilter filter) {
        return employees.stream()
                .filter(emp ->
                        (filter.getFullName() == null ||
                                emp.getFullName().toLowerCase()
                                        .contains(filter.getFullName().toLowerCase()))
                                &&
                                (filter.getDepartment() == null ||
                                        emp.getDepartment().equalsIgnoreCase(filter.getDepartment()))
                )
                .toList();
    }

    public void addEmp(Employee employee){
        employees.add(employee);
    }

    public Employee updateEmp(int id, Employee employee){
        Employee employee1 = getEmpById(id);
        if(employee1 != null){
            employee1.setFullName(employee.getFullName());
            employee1.setEmail(employee.getEmail());
            employee1.setDepartment(employee.getDepartment());
        }
        return employee1;
    }

    public boolean deleteEmp(int id) {
        Employee employee = getEmpById(id);

        if (employee == null) {
            return false;
        }

        employees.remove(employee);
        return true;
    }

}
