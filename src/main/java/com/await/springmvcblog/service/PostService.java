package com.await.springmvcblog.service;

import com.await.springmvcblog.dto.PostDTO;
import com.await.springmvcblog.mapper.PostMapper;
import com.await.springmvcblog.model.Post;
import com.await.springmvcblog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer responsible for handling blog post-related business logic.
 */
@Service
public class PostService {

    private final PostRepository postRepository;  // Repository for interacting with post data
    private final PostMapper postMapper;  // Mapper for converting between Post and PostDTO

    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    /**
     * Retrieves a paginated list of posts, converted to DTOs.
     *
     * @param page the page number (starting at 0)
     * @return a list of PostDTO objects representing the posts
     */
    public List<PostDTO> getAllPosts(int page) {
        return postRepository.findAll(page, 10).stream()  // Fetch posts with pagination
            .map(postMapper::toDTO)  // Convert each post to a DTO
            .collect(Collectors.toList());  // Collect the results into a list
    }

    /**
     * Retrieves a specific post by its ID, converted to a DTO.
     *
     * @param id the ID of the post
     * @return the PostDTO object if found, otherwise null
     */
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id).orElse(null);  // Find post by ID
        return post != null ? postMapper.toDTO(post) : null;  // Convert to DTO if post exists
    }

    /**
     * Creates or updates a post based on the provided DTO.
     *
     * @param postDTO the DTO containing the post data
     * @return the saved PostDTO object
     */
    public PostDTO createOrUpdatePost(PostDTO postDTO) {
        Post post = postMapper.toEntity(postDTO);  // Convert DTO to entity
        return postMapper.toDTO(postRepository.save(post));  // Save entity and convert back to DTO
    }

    /**
     * Deletes a post by its ID.
     *
     * @param id the ID of the post to delete
     */
    public void deletePost(Long id) {
        postRepository.delete(id);  // Remove post by its ID
    }
}
