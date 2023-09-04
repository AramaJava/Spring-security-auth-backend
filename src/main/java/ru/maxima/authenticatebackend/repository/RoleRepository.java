package ru.maxima.authenticatebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxima.authenticatebackend.models.Role;

import java.util.Optional;

/**
 * @author AramaJava 22.07.2023
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByAuthority(String authority);
}
