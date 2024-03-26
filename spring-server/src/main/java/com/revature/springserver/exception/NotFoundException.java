package com.revature.springserver.exception;

/**
 * Exception thrown when attempting to find something from the database and it is not found
 */
public class NotFoundException extends Exception{
    /**
     * Constructs a new NotFoundException with the specified detail message
     *
     * @param message the detailed message
     */
    public NotFoundException(String message) {
        super(message);
    }
}
