package org.launchcode.myblog.controllers;

import org.launchcode.myblog.data.BlogData;
import org.launchcode.myblog.models.Blog;
import org.launchcode.myblog.models.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("blog")
public class BlogController {

    @GetMapping("")
    public String viewEntries(Model model){
        model.addAttribute("title", "Mike's Blog");
        model.addAttribute("entries", BlogData.getAll());
        for(Blog blog: BlogData.getAll()){
            System.out.println(blog.getStatus());
        }
        return "blog/viewBlog";
    }

    @GetMapping("newPost")
    public String renderNewPost(Model model){
        model.addAttribute(new Blog());
        model.addAttribute("statuses", Status.values());
        return "blog/newPost";
    }

    @PostMapping("newPost")
    public String addEntry(Model model, @ModelAttribute @Valid Blog newBlog, Errors errors){

        if(errors.hasErrors()){
            model.addAttribute("statuses", Status.values());
            return "blog/newPost";
        }
        newBlog.setDate(LocalDate.now());
        BlogData.add(newBlog);
        return "redirect:";
    }
}
