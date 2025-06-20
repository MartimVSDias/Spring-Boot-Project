package com.projetoportefolio.ProjetoPortefolio.Services;

import com.projetoportefolio.ProjetoPortefolio.DTO.LoginDTO;
import com.projetoportefolio.ProjetoPortefolio.Repository.UserRepository;
import com.projetoportefolio.ProjetoPortefolio.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class LoginService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    public User login(LoginDTO loginDTO, BindingResult bindingResult) {
        User user = userRepository.findByEmail(loginDTO.getEmail());

        if (user == null) {
            bindingResult.rejectValue("email", "error.loginDTO", "Invalid Email or Password");
            bindingResult.rejectValue("password", "error.loginDTO", "Invalid Email or Password");
            return null;
        }

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            bindingResult.rejectValue("password", "error.loginDTO", "Invalid Email or Password");
            bindingResult.rejectValue("password", "error.loginDTO", "Invalid Email or Password");
            return null;
        }

        return user;
    }
}
