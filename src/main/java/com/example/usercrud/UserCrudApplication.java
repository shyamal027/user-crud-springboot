package com.example.usercrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.usercrud.entity.User;
import com.example.usercrud.repository.UserRepository;

@SpringBootApplication
public class UserCrudApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCrudApplication.class, args);
    }

    // Insert sample users at startup
    @Bean
    CommandLineRunner runner(UserRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new User(null, "Asha", "asha@example.com", 45000));
                repo.save(new User(null, "Ravi", "ravi@example.com", 30000));
                repo.save(new User(null, "Meera", "meera@example.com", 75000));
            }
        };
    }
}
