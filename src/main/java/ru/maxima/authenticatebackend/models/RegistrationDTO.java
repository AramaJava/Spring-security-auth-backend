package ru.maxima.authenticatebackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author AramaJava 22.07.2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
    private String username;
    private String password;
}
