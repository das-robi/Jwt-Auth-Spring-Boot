package com.robin.jwtauth.Controller;

import com.robin.jwtauth.Model.Users;
import com.robin.jwtauth.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/user")
@PreAuthorize("hasRole('USER')")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/profile")
    public ResponseEntity<Users> checkProfile(){
        return ResponseEntity.ok(userServices.getCurrentUserName());
    }

    @DeleteMapping("/deleteprofile/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable int id){

        Users users = userServices.getUsersById(id);

        if (users != null){
            userServices.deleteUserProfile(users);
            return new ResponseEntity<>("Delete Success", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("User Not found", HttpStatus.NOT_FOUND);
        }
    }

}
