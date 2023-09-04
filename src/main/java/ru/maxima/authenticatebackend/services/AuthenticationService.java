package ru.maxima.authenticatebackend.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.maxima.authenticatebackend.models.ApplicationUser;
import ru.maxima.authenticatebackend.models.Role;
import ru.maxima.authenticatebackend.repository.RoleRepository;
import ru.maxima.authenticatebackend.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author AramaJava 22.07.2023
 */

@Service
@Transactional
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

     public ApplicationUser registerUser(String username, String password) {

        String encodedPassword = passwordEncoder.encode(password);

        Role userRole = roleRepository.findByAuthority("USER").orElseThrow(() ->new EntityNotFoundException(username));

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepository.save(new ApplicationUser(0L, username, encodedPassword, authorities));
    }
}
