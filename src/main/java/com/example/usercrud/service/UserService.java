package com.example.usercrud.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.usercrud.dto.UserDto;
import com.example.usercrud.entity.User;
import com.example.usercrud.exception.ResourceNotFoundException;
import com.example.usercrud.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) { this.repo = repo; }

    public List<User> findAll() { return repo.findAll(); }

    public User findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Transactional
    public User create(UserDto dto) {
        // check duplicate email
        Optional<User> existing = repo.findByEmail(dto.getEmail());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Email already in use"); // handled by global
        }
        User u = new User();
        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u.setSalary(dto.getSalary());
        return repo.save(u);
    }

    @Transactional
    public User update(Long id, UserDto dto) {
        User u = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        u.setName(dto.getName());
        u.setEmail(dto.getEmail());
        u.setSalary(dto.getSalary());
        return repo.save(u);
    }

    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("User not found with id " + id);
        repo.deleteById(id);
    }
}
