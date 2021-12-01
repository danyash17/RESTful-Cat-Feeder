package com.bsu.tpbackend.exception.user;

import com.bsu.tpbackend.exception.NotFound;

public class UserNotFoundException extends RuntimeException implements NotFound {
    public UserNotFoundException(String message) {
        super(message);
    }
}
