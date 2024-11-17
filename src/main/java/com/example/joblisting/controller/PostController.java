package com.example.joblisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.joblisting.repository.PostRepository;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.joblisting.model.Post;


@RestController
public class PostController {
    
    @Autowired
    PostRepository repo;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }
    
}
