package org.zviaghintseva.lab4_0.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zviaghintseva.lab4_0.entity.User;

import java.util.ArrayList;
import java.util.Collection;

@Controller
    public class HomeController{
    private Collection<User> users = new ArrayList<>();

    @RequestMapping(value = "/users")
    public String getUsers(Model model){
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping(value = "/addUsers")
    public String getSignUp(Model model) {
        model.addAttribute("users", new User( ));
        return "sign_up";
    }
    @PostMapping(value = "/addUsers")
    public String getSignUp(@ModelAttribute @Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "sign_up";
        }
        users.add(user);
        return "users";
    }

}

