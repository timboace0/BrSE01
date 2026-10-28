package ra.baitap91.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap91.model.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Boolean existsByEmail(String email);
}
