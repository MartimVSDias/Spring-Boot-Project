package com.projetoportefolio.ProjetoPortefolio.Services;

import com.projetoportefolio.ProjetoPortefolio.DTO.RegisterDTO;
import com.projetoportefolio.ProjetoPortefolio.Repository.UserRepository;
import com.projetoportefolio.ProjetoPortefolio.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;


@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    boolean hasErrors = false;

    public void registerUser(RegisterDTO registerDTO, BindingResult bindingResult) {
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            bindingResult.rejectValue("password", "error.registerDTO", "The passwords do not match");
            bindingResult.rejectValue("confirmPassword", "error.registerDTO", "The passwords do not match");
            return;
        }

        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            bindingResult.rejectValue("email", "error.registerDTO", "That email already exists! Please try another one!");
            hasErrors = true;
        }

        if (userRepository.existsByPhoneNumber(registerDTO.getPhoneNumber())) {
            bindingResult.rejectValue("phoneNumber", "error.registerDTO", "That phoneNumber already exists! Please try another one!");
            hasErrors = true;
        }

        if(hasErrors){
            return;
        }


        if (!bindingResult.hasErrors()) {
            User user = new User();
            user.setName(registerDTO.getName());
            user.setEmail(registerDTO.getEmail());
            user.setPassword(registerDTO.getPassword());
            user.setPhoneNumber(registerDTO.getPhoneNumber());
            userRepository.save(user);
        }
    }



}
