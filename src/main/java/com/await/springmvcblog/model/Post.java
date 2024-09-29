package com.await.springmvcblog.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a blog post.
 */
@Getter
@Setter
public class Post {

    private Long id;  // Unique identifier for the post

    @NotBlank(message = "Title is mandatory")  // Title field cannot be blank
    private String title;

    @NotBlank(message = "Content is mandatory")  // Content field cannot be blank
    private String content;

    private String slug;  // URL-friendly version of the title

    private User author;  // Reference to the user who authored the post
}
