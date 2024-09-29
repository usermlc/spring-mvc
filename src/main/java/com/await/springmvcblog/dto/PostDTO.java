package com.await.springmvcblog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for transferring Post data between layers.
 * This class is used to encapsulate the post data without exposing the underlying entity.
 */
@Getter
@Setter
public class PostDTO {

    private Long id;  // Unique identifier for the post

    @NotBlank(message = "Title is mandatory")
    private String title;  // Title of the post

    @NotBlank(message = "Content is mandatory")
    private String content;  // Main content of the post

    private String slug;  // URL-friendly version of the post title

    private Long authorId;  // ID of the author associated with the post
}
