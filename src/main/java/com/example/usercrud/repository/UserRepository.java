package com.example.usercrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.usercrud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
