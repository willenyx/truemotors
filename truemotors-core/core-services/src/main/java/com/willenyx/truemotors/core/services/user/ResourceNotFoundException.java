package com.willenyx.truemotors.core.services.user;

/**
 * Author: William Arustamyan
 * Date: 18/05/2018
 * Time: 9:32 AM
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
