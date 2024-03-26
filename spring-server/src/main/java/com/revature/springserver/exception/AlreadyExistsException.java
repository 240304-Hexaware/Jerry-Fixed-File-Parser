package com.revature.springserver.exception;

/**
 * Exception thrown when attempting to create something that already exists
 */
public class AlreadyExistsException extends Exception{
    /**
     * Constructs a new AlreadyExistsException with the specified detail message
     *
     * @param message the detailed message
     */
    public AlreadyExistsException(String message) {
        super(message);
    }
}

