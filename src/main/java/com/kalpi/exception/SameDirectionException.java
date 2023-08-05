package com.kalpi.exception;

public class SameDirectionException extends Exception {
    public SameDirectionException() {
        super("The surface cannot have two consecutive points in the same direction");
    }
}
