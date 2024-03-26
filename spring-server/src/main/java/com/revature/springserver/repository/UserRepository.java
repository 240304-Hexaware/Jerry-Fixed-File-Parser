package com.revature.springserver.repository;

import com.revature.springserver.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *  Repository class dealing with the database interactions for User
 */
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    /**
     * Retrieves an optional User instance from the database by the provided username and password
     *
     * @param username The username of the user to find
     * @param password The password of the user to find
     * @return An Optional containing the user instance if found, or empty if not found
     */
    Optional<User> findByUsernameAndPassword(String username, String password);

    /**
     * Checks if a user with the provided username exists in the database
     *
     * @param username The username to check
     * @return true if a user with the provided username exists, false otherwise
     */
    boolean existsByUsername(String username);
}
