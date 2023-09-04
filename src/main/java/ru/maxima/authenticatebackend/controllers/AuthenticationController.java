package ru.maxima.authenticatebackend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.maxima.authenticatebackend.models.ApplicationUser;
import ru.maxima.authenticatebackend.models.RegistrationDTO;
import ru.maxima.authenticatebackend.services.AuthenticationService;

/**
 * @author AramaJava 22.07.2023
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body) {
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
}
