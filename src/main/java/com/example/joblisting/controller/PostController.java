package com.example.joblisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.joblisting.model.Post;
import com.example.joblisting.repository.PostRepository;
import com.example.joblisting.repository.SearchRepository;


@RestController
public class PostController {
    
    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository searchrepo;

    @GetMapping("/allposts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text) {
        return searchrepo.findByText(text);
    }

    @PostMapping("/addpost")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }
    
}
