package com.revature.springserver.service;

import com.revature.springserver.exception.AlreadyExistsException;
import com.revature.springserver.exception.NotFoundException;
import com.revature.springserver.model.User;
import com.revature.springserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing business logic for User
 */
@Service
public class UserService {
    private UserRepository userRepository;

    /**
     * Constructs a new UserService with the provided UserRepository
     *
     * @param userRepository The UserRepository to be used for database operations
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Finds a user by their user ID
     *
     * @param userId The ID of the user to find
     * @return The found user
     * @throws NotFoundException If no user is found with the provided ID
     */
    public User findUser(String userId) throws NotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));
    }

    /**
     * Finds a user by their username and password
     *
     * @param username The username of the user to find
     * @param password The password of the user to find
     * @return The found user
     * @throws NotFoundException If no user is found with the provided username and password
     */
    public User findUserByUsernameAndPassword(String username, String password) throws NotFoundException{
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new NotFoundException("User not found with username and password"));
    }

    /**
     * Registers a new user with the provided username and password
     *
     * @param username The username for the new user
     * @param password The password for the new user
     * @return The newly registered user
     * @throws AlreadyExistsException If a user with the provided username already exists
     */
    public User registerUser(String username, String password, String role) throws AlreadyExistsException {
        // Check if the username is already taken
        if (userRepository.existsByUsername(username)) {
            throw new AlreadyExistsException("Username already exists: " + username);
        }

        // Create a new user
        User user = new User(username, password, role);

        // Save the user to the database
        return userRepository.save(user);
    }

    /**
     * Authenticates a user with the provided username and password
     *
     * @param username The username of the user to authenticate
     * @param password The password of the user to authenticate
     * @return The authenticated user
     * @throws NotFoundException If no user is found with the provided username and password
     */
    public User loginUser(String username, String password) throws NotFoundException {
        // Return the authenticated user
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new NotFoundException("User not found with username and password"));
    }


}
