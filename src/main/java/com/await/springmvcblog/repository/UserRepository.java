package com.await.springmvcblog.repository;

import com.await.springmvcblog.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository for managing User entities in memory.
 */
@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();  // Storage for User objects
    private Long currentId = 1L;  // Tracks the next available ID

    /**
     * Returns a list of all users.
     *
     * @return a list containing all User objects
     */
    public List<User> findAll() {
        return users;  // Return the entire list of users
    }

    /**
     * Finds a user by their unique ID.
     *
     * @param id the ID of the user to find
     * @return an Optional containing the User if found, or empty if not found
     */
    public Optional<User> findById(Long id) {
        // Searches for a user by their ID and returns it wrapped in an Optional
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    /**
     * Saves a new user or updates an existing user.
     *
     * @param user the user to save or update
     * @return the saved or updated User object
     */
    public User save(User user) {
        if (user.getId() == null) {
            // If no ID is set, assign a new one
            user.setId(currentId++);
            users.add(user);  // Add the new user to the list
        } else {
            // If the user already exists, update their information
            users.removeIf(existingUser -> existingUser.getId().equals(user.getId()));
            users.add(user);  // Add the updated user to the list
        }
        return user;  // Return the saved user object
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to delete
     */
    public void delete(Long id) {
        // Remove the user with the given ID from the list
        users.removeIf(user -> user.getId().equals(id));
    }
}
