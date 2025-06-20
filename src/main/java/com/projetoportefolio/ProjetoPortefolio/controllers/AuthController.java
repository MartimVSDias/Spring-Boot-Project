package com.projetoportefolio.ProjetoPortefolio.controllers;


import com.projetoportefolio.ProjetoPortefolio.DTO.LoginDTO;
import com.projetoportefolio.ProjetoPortefolio.DTO.RegisterDTO;
import com.projetoportefolio.ProjetoPortefolio.Repository.UserRepository;
import com.projetoportefolio.ProjetoPortefolio.Services.RegisterService;
import com.projetoportefolio.ProjetoPortefolio.models.User;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository u;

    @Autowired
    private RegisterService registerService;


    @GetMapping("/")
    public String dashboard() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerDTO", new RegisterDTO());
        return "register";
    }


    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("loginDTO") LoginDTO loginDTO,  BindingResult bindingResult, Model model, HttpServletResponse response) {
        System.out.println("Email: " + loginDTO.getEmail());
        System.out.println("Password: " + loginDTO.getPassword());

        User foundUser = this.u.login(loginDTO.getEmail(), loginDTO.getPassword());
        if(foundUser != null) {
            return "redirect:/";
        }
        model.addAttribute("error", "Invalid User!");
        return "login";
    }


    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("registerDTO") RegisterDTO registerDTO, BindingResult bindingResult, Model model) {
        registerService.registerUser(registerDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        return "redirect:/login";
    }

}
