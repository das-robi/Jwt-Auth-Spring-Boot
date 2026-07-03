package com.robin.jwtauth.Controller;

import com.robin.jwtauth.Model.Users;
import com.robin.jwtauth.Service.ProductService;
import com.robin.jwtauth.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/admin")
@PreAuthorize("hasRole('admin')")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserController userController;

//    Get All Users
    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers(){

        return new ResponseEntity<>(userServices.getAllUsers(), HttpStatus.OK);
    }

    //Delete Users by Id
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){

        userController.deleteProfile(id);

        return new ResponseEntity<>("Deleted success", HttpStatus.OK);
    }

}
