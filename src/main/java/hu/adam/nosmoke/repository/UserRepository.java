package hu.adam.nosmoke.repository;

import hu.adam.nosmoke.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
