package com.example.joblisting.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.joblisting.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.joblisting.model.Post;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class PostController {
    
    @Autowired
    PostRepository repo;

    @GetMapping("/allposts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    @PostMapping("/addpost")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }
    
}
