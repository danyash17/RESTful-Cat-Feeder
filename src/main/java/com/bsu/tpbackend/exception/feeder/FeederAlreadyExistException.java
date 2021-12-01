package com.bsu.tpbackend.exception.feeder;

import com.bsu.tpbackend.exception.AlreadyExist;

public class FeederAlreadyExistException extends RuntimeException implements AlreadyExist {
    public FeederAlreadyExistException(String message) {
        super(message);
    }
}
