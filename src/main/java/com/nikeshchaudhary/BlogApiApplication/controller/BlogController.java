package com.nikeshchaudhary.BlogApiApplication.controller;

import com.nikeshchaudhary.BlogApiApplication.dto.BlogPostDto;
import com.nikeshchaudhary.BlogApiApplication.model.BlogPost;
import com.nikeshchaudhary.BlogApiApplication.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<BlogPost> getAllPosts() {
        return blogService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<BlogPost> createPost(@Validated @RequestBody BlogPostDto blogPostDto) {
        return ResponseEntity.ok(blogService.createPost(blogPostDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updatePost(@PathVariable Long id, @Validated @RequestBody BlogPostDto updatedPostDto) {
        return ResponseEntity.ok(blogService.updatePost(id, updatedPostDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        blogService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
