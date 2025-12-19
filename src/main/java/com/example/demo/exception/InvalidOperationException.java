// src/main/java/com/example/demo/exception/InvalidOperationException.java
package com.example.demo.exception;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String message) {
        super(message);
    }
}