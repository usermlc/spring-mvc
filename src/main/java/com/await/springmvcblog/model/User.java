package com.await.springmvcblog.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a user in the system.
 */
@Getter
@Setter
public class User {

    private Long id;  // Unique identifier for the user

    private String username;  // Username used for logging in and identification
}
