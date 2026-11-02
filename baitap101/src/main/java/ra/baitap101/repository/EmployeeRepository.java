package ra.baitap101.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap101.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}