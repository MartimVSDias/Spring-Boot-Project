package com.projetoportefolio.ProjetoPortefolio.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 6, message = "The name must have 6 characters")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "The email must be valid.")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 250, message = "The passwords must have between 6 and 250 characters")
    private String password;

    @Pattern(regexp = "^\\d{9}$", message="The PhoneNumber must have 9 digits")
    private String phoneNumber;


    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    public User() {
    }

    public User(long id, Role role, String phoneNumber, String password, String email, String name) {
        this.id = id;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
