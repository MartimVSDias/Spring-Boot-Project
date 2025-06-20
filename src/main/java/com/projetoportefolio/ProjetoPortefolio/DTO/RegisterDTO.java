package com.projetoportefolio.ProjetoPortefolio.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterDTO {


    @NotBlank(message = "Name cannot be empty")
    @Size(min = 6, message = "The name must have 6 characters")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "The email must be valid.")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 250, message = "The password must have between 6 and 250 characters")
    private String password;

    @NotBlank(message = "Confirm Password cannot be empty")
    private String confirmPassword;

    @Pattern(regexp = "^\\d{9}$", message="The PhoneNumber must have 9 digits")
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
