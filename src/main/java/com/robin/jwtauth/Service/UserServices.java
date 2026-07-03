package com.robin.jwtauth.Service;

import com.robin.jwtauth.Model.Users;
import com.robin.jwtauth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

//    User verify here by JWT Token
    public String verifyUsers(Users users) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));

        if (authentication.isAuthenticated()){
            return jwttOkenService.GenerateKey(users.getUsername());
        }

        return "Fail";
    }

    /** Get Users By Id **/
    public Users getUsersById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Users not found"));
    }


//    User can check their profile
    public Users getCurrentUserName() {
        String userName = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return repository.getUserByUsername(userName);
    }

    /** Delete users */
    public void deleteUserProfile(Users users) {
        repository.delete(users);
    }


    /** Admin can access all Users */
    public List<Users> getAllUsers() {
      return repository.findAll();
    }
}
