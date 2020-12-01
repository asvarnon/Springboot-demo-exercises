package com.codeup.demo.Controllers;

import com.codeup.demo.model.Post;
import com.codeup.demo.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String posts(Model viewModel) {
        viewModel.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/ads/search")
    public String search(@RequestParam(name="term") String term, Model viewModel){
       term = "%"+term+"%";
       List<Post> dbPosts = postDao.findAllByTitleIsLike(term);
       viewModel.addAttribute("posts", dbPosts);
       return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable int id, Model model){
        model.addAttribute("postNum", id);

        return "/posts/index";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(){
        return "/posts/new";
    }

    @PostMapping("/posts/create") @ResponseBody
    public String createPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String body
    ){
        Post post = new Post(title, body);
        Post dbPost = postDao.save(post);
        return "create new post with the id" + dbPost.getId();
    }

//    @PostMapping("/posts/delete") @ResponseBody
//    public String deletePost(){
//        return;
//    }


}
