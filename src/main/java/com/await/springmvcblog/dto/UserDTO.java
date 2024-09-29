package com.await.springmvcblog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for transferring User data between layers.
 * This class encapsulates the user's information, ensuring validation rules are applied.
 */
@Getter
@Setter
public class UserDTO {

    private Long id;  // Unique identifier for the user

    @NotBlank(message = "Username is mandatory")
    private String username;  // Username chosen by the user, must not be blank

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;  // User's email address, validated to ensure it is properly formatted
}
