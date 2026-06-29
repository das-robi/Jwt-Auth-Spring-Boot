package com.robin.jwtauth.Service;

import com.robin.jwtauth.Model.UserPrinciple;
import com.robin.jwtauth.Model.Users;
import com.robin.jwtauth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetails implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Get User Name: " + username);

        Users users = repository.getUserByUsername(username);

        if (users == null){
            System.out.println("User is Not Found");
            throw new UsernameNotFoundException("Not Found");
        }

        return new UserPrinciple(users);
    }
}
