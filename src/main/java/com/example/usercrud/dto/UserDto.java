package com.example.usercrud.dto;

import jakarta.validation.constraints.*;        
public class UserDto {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Salary is required")
    @Min(0)
    private Integer salary;

    public UserDto() {}

    public UserDto(Long id, String name, String email, Integer salary) {
        this.id = id; this.name = name; this.email = email; this.salary = salary;
    }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Integer getSalary() { return salary; }
    public void setSalary(Integer salary) { this.salary = salary; }
}
