package com.codeup.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts") @ResponseBody
    public String posts(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}") @ResponseBody
    public String post(@PathVariable int id){
        return "post number: " + id;
    }

    @GetMapping("/posts/create") @ResponseBody
    public String createPost(){
        return "Here is the form to create a post";
    }

    @PostMapping("/posts/create") @ResponseBody
    public String createPost(String post){
        return "create new " + post;
    }
}