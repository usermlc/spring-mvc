package com.await.springmvcblog.controller;

import com.await.springmvcblog.dto.PostDTO;
import com.await.springmvcblog.service.PostService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling requests related to blog posts.
 * Provides methods for listing, viewing, creating, editing, and deleting posts.
 */
@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;  // Service layer for handling post operations

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Displays a paginated list of posts.
     *
     * @param page the current page number (default is 0)
     * @param model the model to store attributes for rendering the view
     * @return the name of the HTML template for the post list
     */
    @GetMapping
    public String listPosts(@RequestParam(defaultValue = "0") int page, Model model) {
        List<PostDTO> posts = postService.getAllPosts(page);
        model.addAttribute("posts", posts);
        return "postList";  // View template for displaying the list of posts
    }

    /**
     * Displays the details of a specific post by its ID.
     *
     * @param id the ID of the post to display
     * @param model the model to store the post data
     * @return the name of the HTML template for post details or a 404 page if not found
     */
    @GetMapping("/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        PostDTO post = postService.getPostById(id);
        if (post == null) {
            return "404";  // If the post is not found, return a 404 view
        }
        model.addAttribute("post", post);
        return "postDetail";  // View template for displaying post details
    }

    /**
     * Displays the form for adding a new post.
     *
     * @param model the model to store the new post data
     * @return the name of the HTML template for the post form
     */
    @GetMapping("/add")
    public String showAddPostForm(Model model) {
        model.addAttribute("post", new PostDTO());
        return "postForm";  // View template for adding a new post
    }

    /**
     * Handles the form submission for adding a new post.
     *
     * @param postDTO the data transfer object for the post
     * @param result the binding result for validation errors
     * @return a redirect to the post list or the form again if there are errors
     */
    @PostMapping("/add")
    public String addPost(@Valid @ModelAttribute("post") PostDTO postDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "postForm";  // Return to the form if there are validation errors
        }
        postService.createOrUpdatePost(postDTO);
        return "redirect:/posts";  // Redirect to the post list after saving
    }

    /**
     * Displays the form for editing an existing post by its ID.
     *
     * @param id the ID of the post to edit
     * @param model the model to store the post data
     * @return the name of the HTML template for the post form
     */
    @GetMapping("/edit/{id}")
    public String showEditPostForm(@PathVariable Long id, Model model) {
        PostDTO post = postService.getPostById(id);
        if (post == null) {
            return "404";  // If the post is not found, return a 404 view
        }
        model.addAttribute("post", post);
        return "postForm";  // View template for editing a post
    }

    /**
     * Handles the form submission for editing an existing post.
     *
     * @param id the ID of the post being edited
     * @param postDTO the data transfer object for the post
     * @param result the binding result for validation errors
     * @return a redirect to the post list or the form again if there are errors
     */
    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, @Valid @ModelAttribute("post") PostDTO postDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "postForm";  // Return to the form if there are validation errors
        }
        postDTO.setId(id);
        postService.createOrUpdatePost(postDTO);
        return "redirect:/posts";  // Redirect to the post list after updating
    }

    /**
     * Deletes a post by its ID.
     *
     * @param id the ID of the post to delete
     * @return a redirect to the post list after deletion
     */
    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";  // Redirect to the post list after deletion
    }
}
