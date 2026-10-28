package ra.baitap101.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.baitap101.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
