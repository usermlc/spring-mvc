package com.await.springmvcblog.repository;

import com.await.springmvcblog.model.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * In-memory repository for storing posts.
 */
@Repository
public class PostRepository {

    private final List<Post> posts = new ArrayList<>();  // Internal storage for posts
    private Long currentId = 1L;  // Tracks the next ID to be assigned
    private final Set<Long> recycledIds = new HashSet<>();  // Stores IDs of deleted posts for potential reuse

    /**
     * Retrieves a paginated list of posts.
     *
     * @param page the current page number (starting at 0)
     * @param size the number of posts per page
     * @return a sublist of posts for the requested page
     */
    public List<Post> findAll(int page, int size) {
        int startIndex = page * size;  // Calculate the starting index
        int endIndex = Math.min(startIndex + size, posts.size());  // Calculate the ending index
        return posts.subList(startIndex, endIndex);  // Return the paginated sublist
    }

    /**
     * Finds a post by its unique ID.
     *
     * @param id the ID of the post to find
     * @return an Optional containing the post if found, otherwise empty
     */
    public Optional<Post> findById(Long id) {
        // Searches for a post by its ID and returns it wrapped in an Optional
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    /**
     * Saves a new post or updates an existing one.
     *
     * @param post the post to save or update
     * @return the saved post
     */
    public Post save(Post post) {
        if (post.getId() == null) {
            // If the post is new (no ID assigned), assign a new or recycled ID
            if (!recycledIds.isEmpty()) {
                Long idToReuse = recycledIds.iterator().next();
                recycledIds.remove(idToReuse);
                post.setId(idToReuse);
            } else {
                post.setId(currentId++);  // Assign a new ID and increment the counter
            }
            posts.add(post);  // Add the new post to the list
        } else {
            // If the post exists, replace it with the updated version
            posts.removeIf(existingPost -> existingPost.getId().equals(post.getId()));
            posts.add(post);  // Add the updated post to the list
        }
        return post;  // Return the saved post
    }

    /**
     * Deletes a post by its ID and marks the ID as available for reuse.
     *
     * @param id the ID of the post to delete
     */
    public void delete(Long id) {
        posts.removeIf(post -> post.getId().equals(id));  // Remove the post by its ID
        recycledIds.add(id);  // Add the ID to the set of recycled IDs
    }
}
