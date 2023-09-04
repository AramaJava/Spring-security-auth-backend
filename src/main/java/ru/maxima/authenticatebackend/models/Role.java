package ru.maxima.authenticatebackend.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author AramaJava 21.07.2023
 */
@Entity
@Data
@Table(name="roles")
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private Integer RoleId;
    private String authority;


    public Role(String authority) {
    }
}
