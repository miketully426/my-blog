package org.launchcode.myblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("")
    public String landingPage(Model model){
        model.addAttribute("title", "Mike's Blog");
        return "home";
    }
}
