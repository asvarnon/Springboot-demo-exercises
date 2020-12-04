package com.codeup.demo.Controllers;

import com.codeup.demo.model.Post;
import com.codeup.demo.model.User;
import com.codeup.demo.repos.PostRepository;
import com.codeup.demo.repos.UserRepository;
import com.codeup.demo.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String posts(Model viewModel) {
        viewModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/search")
    public String search(@RequestParam(name="term") String term, Model viewModel){
       term = "%"+term+"%";
       List<Post> dbPosts = postDao.findAllByTitleIsLike(term);
       viewModel.addAttribute("posts", dbPosts);
       return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String showCreateForm(Model viewModel){
        viewModel.addAttribute("post", new Post());
        return "posts/new";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToBeSaved){
        User userDb = userDao.getOne(1L);
        postToBeSaved.setOwner(userDb);
        Post dbPost = postDao.save(postToBeSaved);
        emailService.prepareAndSend(dbPost, "Post has been created", "You can find it with the ID of: " + dbPost.getId());
        return "redirect:/posts/" + dbPost.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post postToBeEdited){
        User userDb = userDao.getOne(1L); //a user obj coming from a session.
        postToBeEdited.setOwner(userDb);
        postDao.save(postToBeEdited);
        return "redirect:/posts";
    }


    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }


}
