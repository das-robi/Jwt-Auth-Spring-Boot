package com.robin.jwtauth.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "usertable")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;

}
