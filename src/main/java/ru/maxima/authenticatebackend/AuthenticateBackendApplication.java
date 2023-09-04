package ru.maxima.authenticatebackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.maxima.authenticatebackend.models.ApplicationUser;
import ru.maxima.authenticatebackend.models.Role;
import ru.maxima.authenticatebackend.repository.RoleRepository;
import ru.maxima.authenticatebackend.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AuthenticateBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticateBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
       return args -> {
           if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
           Role adminRole = roleRepository.save(new Role("ADMIN"));
           roleRepository.save(new Role ("USER"));

           Set<Role> roles = new HashSet<>();
           roles.add(adminRole);

           ApplicationUser admin = new ApplicationUser(1L, "admin", passwordEncoder.encode("password"), roles);
           userRepository.save(admin);
       };
    }
}
