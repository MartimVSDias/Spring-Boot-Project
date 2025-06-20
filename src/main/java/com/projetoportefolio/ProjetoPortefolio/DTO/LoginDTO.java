package com.projetoportefolio.ProjetoPortefolio.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginDTO {

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "The email must be valid.")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 250, message = "The passwords must have between 6 and 250 characters")
    private String password;

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
}
