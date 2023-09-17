package rahimov.FinallySec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rahimov.FinallySec.models.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
