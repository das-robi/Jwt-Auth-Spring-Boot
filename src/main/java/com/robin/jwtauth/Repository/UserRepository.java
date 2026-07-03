package com.robin.jwtauth.Repository;

import com.robin.jwtauth.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users getUserByUsername(String username);
}
