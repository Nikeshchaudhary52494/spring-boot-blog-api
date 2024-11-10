package com.nikeshchaudhary.BlogApiApplication.repository;

import com.nikeshchaudhary.BlogApiApplication.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
