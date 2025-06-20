package com.projetoportefolio.ProjetoPortefolio.controllers;


import com.projetoportefolio.ProjetoPortefolio.Repository.UserRepository;
import com.projetoportefolio.ProjetoPortefolio.models.User;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @Autowired
    private UserRepository u;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/")
    public String dashboard() {
        return "index";
    }


    @PostMapping("/login")
    public String loginUser(User user, Model model, HttpServletResponse response) {
        System.out.println("Email" + user.getEmail());
        System.out.println("Password" + user.getPassword());

        User foundUser = this.u.login(user.getEmail(), user.getPassword());
        if(foundUser != null) {
            return "redirect:/";
        }
        model.addAttribute("error", "Invalid User!");
        return "login";
    }




    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Invalid User!");
            return "register";
        }

        u.save(user);

        return "redirect:/login";
    }


}
