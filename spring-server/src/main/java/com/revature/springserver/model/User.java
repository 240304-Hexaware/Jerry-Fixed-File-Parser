package com.revature.springserver.model;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * Class that models a User
 */
@Document("user")
public class User {

    /**
     * An id for this User
     */
    @Field("_id")
    @MongoId(FieldType.OBJECT_ID)
    private ObjectId userId;

    /**
     * A username for this User (must be unique and not blank)
     */
    @Field(name = "username")
    private String username;

    /**
     * A password for this User (must be over 12 characters)
     */
    @Field(name = "password")
    private String password;

    /**
     * Specifies what role the User is
     * Can be either "user" or "admin"
     */
    @Field(name = "role")
    private String role;

    /**
     * Default, no args constructor
     */
    public User(){}

    /**
     * Constructor with all fields and id generated by database
     *
     * @param username the username used by a user to login
     * @param password the password used by the user to login
     * @param role what role and permissions the user has
     */
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Constructor with all fields and inputted id
     *
     * @param userId the id associated with a user
     * @param username the username used by a user to login
     * @param password the password used by the user to login
     * @param role what role and permissions the user has
     */
    public User(ObjectId userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * @return Gets the value of user_id and returns user_id
     */
    public ObjectId getUserId() {
        return userId;
    }

    /**
     * Sets the user_id
     * You can use getUser_id() to get the value of user_id
     *
     * @param userId the id associated with a user
     */
    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    /**
     * @return Gets the value of username and returns username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * You can use getUsername() to get the value of username
     *
     * @param username the username of a user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return Gets the value of password and returns password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * You can use getPassword() to get the value of password
     *
     * @param password user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Gets the value of role and returns role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role
     * You can use getRole() to get the value of role
     *
     * @param role the role of a user
     */
    public void setRole(String role) {
        this.role = role;
    }
}