package com.example.joblisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.joblisting.model.Post;
import com.example.joblisting.repository.PostRepository;
import com.example.joblisting.repository.SearchRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository searchrepo;

    @GetMapping("/allposts")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    @CrossOrigin(origins = "http://localhost:3000")

    public List<Post> search(@PathVariable String text) {
        return searchrepo.findByText(text);
    }

    @PostMapping("/addpost")
    @CrossOrigin(origins = "http://localhost:3000")

    public Post addPost(@RequestBody Post post) {
        return repo.save(post);
    }

}
