package com.codeup.demo.Controllers;

import com.codeup.demo.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("Post title", "post body"));
        posts.add(new Post("Post title num1", "post body num1"));

        model.addAttribute("post-list", posts);
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
