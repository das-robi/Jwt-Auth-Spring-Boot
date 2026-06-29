package com.robin.jwtauth.Service;

import com.robin.jwtauth.Model.Users;
import com.robin.jwtauth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JwtTokenService jwttOkenService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users userRegister(Users users) {

        users.setPassword(encoder.encode(users.getPassword()));
        return repository.save(users);
    }

    public String verifyUsers(Users users) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));

        if (authentication.isAuthenticated()){
            return jwttOkenService.GenerateKey(users.getUsername());
        }

        return "Fail";
    }
}
