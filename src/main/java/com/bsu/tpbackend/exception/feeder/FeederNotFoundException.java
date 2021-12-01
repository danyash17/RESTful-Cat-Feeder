package com.bsu.tpbackend.exception.feeder;

import com.bsu.tpbackend.exception.NotFound;

public class FeederNotFoundException extends RuntimeException implements NotFound {
    public FeederNotFoundException(String message) {
        super(message);
    }
}
