package az.bron.business.feature.user.domain.repository;

import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.user.domain.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    User findByEmailIgnoreCase(String emailId);

}