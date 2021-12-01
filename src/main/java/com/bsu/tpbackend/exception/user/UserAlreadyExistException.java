package com.bsu.tpbackend.exception.user;

import com.bsu.tpbackend.exception.AlreadyExist;

public class UserAlreadyExistException extends RuntimeException implements AlreadyExist {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
