package com.example.testtasksecurity.controller;

import com.example.testtasksecurity.entity.UserEntity;
import com.example.testtasksecurity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegistrationController {

    UserService userService;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userEntity", new UserEntity());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userEntity") UserEntity userEntity, Model model){
        userService.saveUser(userEntity);
        return "redirect:/login";

    }
}
