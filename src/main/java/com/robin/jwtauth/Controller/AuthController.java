package com.robin.jwtauth.Controller;

import com.robin.jwtauth.Model.Users;
import com.robin.jwtauth.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserServices userServices;


    @PostMapping("/register")
    public Users registerUser(@RequestBody Users users){
        return userServices.userRegister(users);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Users users){
        return userServices.verifyUsers(users);
    }

}
