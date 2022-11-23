package org.launchcode.myblog.controllers;

import org.launchcode.myblog.data.BlogData;
import org.launchcode.myblog.data.TagData;
import org.launchcode.myblog.data.UserData;
import org.launchcode.myblog.models.Blog;
import org.launchcode.myblog.models.Status;
import org.launchcode.myblog.models.Tag;
import org.launchcode.myblog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogData blogData;

    // Add userdata
    @Autowired
    private UserData userData;

    @Autowired
    private TagData tagData;

    @GetMapping("")
    public String viewEntries(Model model){
        model.addAttribute("title", "Mike's Blog");
        model.addAttribute("entries", blogData.findAll());
        return "blog/viewBlog";
    }

    // Update newpost display to include user list
    @GetMapping("newPost")
    public String renderNewPost(Model model){
        model.addAttribute(new Blog());
        model.addAttribute("statuses", Status.values());
        model.addAttribute("users", userData.findAll());
        model.addAttribute("tags", tagData.findAll());
        return "blog/newPost";
    }

    @PostMapping("newPost")
    public String addEntry(Model model, @ModelAttribute @Valid Blog newBlog, @RequestParam List<Integer> inputTags, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("statuses", Status.values());
            model.addAttribute("users", userData.findAll());
            model.addAttribute("tags", tagData.findAll());
            return "blog/newPost";
        }
        List<Tag> tags = (List<Tag>) tagData.findAllById(inputTags);
        newBlog.setTags(tags);
        newBlog.setDate(LocalDate.now());
        blogData.save(newBlog);
        return "redirect:";
    }

    // Create handler to get blogs by user id
    @GetMapping("/user/{userId}")
    public String viewEntriesByUser(Model model, @PathVariable int userId) {
        Optional<User> user = userData.findById(userId);
        model.addAttribute("title", "Mike's Blog");
        if(user.isEmpty()){
            //If User is invalid, just display all blogs
            model.addAttribute("entries", blogData.findAll());
        } else {
            model.addAttribute("entries", user.get().getPosts());
        }
        return "blog/viewBlog";
    }
}

