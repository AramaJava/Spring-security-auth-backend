package ru.maxima.authenticatebackend.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.maxima.authenticatebackend.repository.UserRepository;



/**
 * @author AramaJava 22.07.2023
 */
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       System.out.println("In the user detail service");

       return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user is not valid!"));
    }
}
