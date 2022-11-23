package org.launchcode.myblog.controllers;

import org.launchcode.myblog.data.TagData;
import org.launchcode.myblog.data.UserData;
import org.launchcode.myblog.models.Blog;
import org.launchcode.myblog.models.Status;
import org.launchcode.myblog.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("tag")
public class TagController {

    @Autowired
    private TagData tagData;

    @Autowired
    private UserData userData;

    @PostMapping("add")
    public String addTag(@ModelAttribute @Valid Tag tag, @ModelAttribute Blog blog, Errors errors, Model model){
        model.addAttribute("statuses", Status.values());
        model.addAttribute("users", userData.findAll());
        model.addAttribute("blog", blog);
        if(errors.hasErrors()){
            model.addAttribute("tags", tagData.findAll());
            return "blog/newPost";
        }
        tagData.save(tag);
        model.addAttribute("tags", tagData.findAll());
        return "blog/newPost";
    }
}
