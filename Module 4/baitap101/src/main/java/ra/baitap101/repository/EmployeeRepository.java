package ra.baitap101.repository;

import org.springframework.stereotype.Repository;
import ra.baitap101.model.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    List<Employee> employees = new ArrayList<>(
            List.of(
                    new Employee(1,"Nguyen Van A", 2000D),
                    new Employee(2,"Nguyen Van B", 1500D),
                    new Employee(3,"Nguyen Van C", 2500D)
            )
    );

    public List<Employee> findAllEmployee(){
        return employees;
    }
}
