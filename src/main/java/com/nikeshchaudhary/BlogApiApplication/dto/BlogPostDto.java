package com.nikeshchaudhary.BlogApiApplication.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class BlogPostDto {
    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Content is mandatory")
    private String content;
}
