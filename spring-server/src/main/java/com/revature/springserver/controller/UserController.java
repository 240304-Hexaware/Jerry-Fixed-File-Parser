package com.revature.springserver.controller;

import com.revature.springserver.exception.AlreadyExistsException;
import com.revature.springserver.exception.NotFoundException;
import com.revature.springserver.model.User;
import com.revature.springserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller that defines REST endpoints and handles HTTP Requests
 */
@RestController
@RequestMapping("/api/auth")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Register a new user
     * POST /api/auth/register
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public User register(@RequestParam("username") String username, @RequestParam("password") String password,
                         @RequestParam("role") String role) throws AlreadyExistsException {
        return userService.registerUser(username, password, role);
    }

    /**
     * Authenticate user login
     * POST /api/auth/login
     */
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestParam("username") String username, @RequestParam("password") String password) throws NotFoundException {
        return userService.loginUser(username, password);
    }

    //Exception Handlers
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String queryNotFound(NotFoundException e) {
        System.out.println(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String addAlreadyExists(AlreadyExistsException e) {
        System.out.println(e.getMessage());
        return e.getMessage();
    }
}
