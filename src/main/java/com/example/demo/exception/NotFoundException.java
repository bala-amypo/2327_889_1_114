// src/main/java/com/example/demo/exception/NotFoundException.java
package com.example.demo.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}