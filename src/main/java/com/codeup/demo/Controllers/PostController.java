package com.codeup.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(){
        return "/posts/show";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable int id, Model model){
        model.addAttribute("postNum", id);

        return "/posts/index";
    }

    @GetMapping("/posts/create") @ResponseBody
    public String showCreateForm(){
        return "Here is the form to create a post";
    }

    @PostMapping("/posts/create") @ResponseBody
    public String submitPost(){
        return "create new post";
    }
}
