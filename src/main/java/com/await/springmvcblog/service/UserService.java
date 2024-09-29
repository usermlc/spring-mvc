package com.await.springmvcblog.service;

import com.await.springmvcblog.dto.UserDTO;
import com.await.springmvcblog.mapper.UserMapper;
import com.await.springmvcblog.model.User;
import com.await.springmvcblog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer responsible for handling business logic related to users.
 */
@Service
public class UserService {

    private final UserRepository userRepository;  // Repository for accessing user data
    private final UserMapper userMapper;  // Mapper for converting between User and UserDTO

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Retrieves all users from the repository and converts them to DTOs.
     *
     * @return a list of UserDTO objects representing all users
     */
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()  // Fetch all users
            .map(userMapper::toDTO)  // Convert each user to DTO
            .collect(Collectors.toList());  // Collect and return as a list of DTOs
    }

    /**
     * Finds a user by their unique ID and converts the user to a DTO.
     *
     * @param id the ID of the user to retrieve
     * @return the UserDTO object if found, otherwise null
     */
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);  // Find user by ID
        return user != null ? userMapper.toDTO(user) : null;  // Convert to DTO or return null
    }

    /**
     * Creates or updates a user based on the provided DTO data.
     *
     * @param userDTO the data transfer object containing user information
     * @return the saved or updated UserDTO object
     */
    public UserDTO createOrUpdateUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);  // Convert DTO to entity
        return userMapper.toDTO(userRepository.save(user));  // Save the entity and return the DTO
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to delete
     */
    public void deleteUser(Long id) {
        userRepository.delete(id);  // Remove user by ID
    }
}
