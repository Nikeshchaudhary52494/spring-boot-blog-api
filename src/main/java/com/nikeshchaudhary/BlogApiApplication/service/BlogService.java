package com.nikeshchaudhary.BlogApiApplication.service;

import com.nikeshchaudhary.BlogApiApplication.dto.BlogPostDto;
import com.nikeshchaudhary.BlogApiApplication.exception.ResourceNotFoundException;
import com.nikeshchaudhary.BlogApiApplication.model.BlogPost;
import com.nikeshchaudhary.BlogApiApplication.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost getPostById(Long id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with ID: " + id));
    }

    public BlogPost createPost(BlogPostDto blogPostDto) {
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(blogPostDto.getTitle());
        blogPost.setContent(blogPostDto.getContent());
        return blogPostRepository.save(blogPost);
    }

    public BlogPost updatePost(Long id, BlogPostDto updatedPostDto) {
        BlogPost existingPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with ID: " + id));

        existingPost.setTitle(updatedPostDto.getTitle());
        existingPost.setContent(updatedPostDto.getContent());
        return blogPostRepository.save(existingPost);
    }

    public void deletePost(Long id) {
        if (!blogPostRepository.existsById(id)) {
            throw new ResourceNotFoundException("Post not found with ID: " + id);
        }
        blogPostRepository.deleteById(id);
    }
}
