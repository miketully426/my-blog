package org.launchcode.myblog.controllers;

import org.launchcode.myblog.data.UserData;
import org.launchcode.myblog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserData userData;

    @GetMapping("")
    public String getUsers(Model model){
        model.addAttribute("title", "Mike's Blog");
        model.addAttribute("users", userData.findAll());
        model.addAttribute("newUser", new User());
        return "user/index";
    }

    @PostMapping("")
    public String addUser(Model model, @ModelAttribute @Valid User newUser, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("users", userData.findAll());
            return "user/index";
        }
        userData.save(newUser);
        return "redirect:user";
    }
}
