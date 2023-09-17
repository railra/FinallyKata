package rahimov.FinallySec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rahimov.FinallySec.models.User;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
