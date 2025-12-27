package com.example.demo;

import com.example.demo.entity.User;

public class FullProjectTest {

    public static void main(String[] args) {

        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("1234");

        System.out.println("Application compiled successfully");
        System.out.println("User email: " + user.getEmail());
    }
}
