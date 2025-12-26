// package com.example.demo.controller;

// import com.example.demo.entity.User;
// import com.example.demo.service.impl.UserServiceImpl;
// import com.example.demo.config.JwtTokenProvider;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     private final UserServiceImpl userService;
//     private final JwtTokenProvider jwtProvider;

//     public AuthController(UserServiceImpl userService) {
//         this.userService = userService;
//         this.jwtProvider = new JwtTokenProvider(
//                 "verysecretkeyverysecretkey123456",
//                 3600000
//         );
//     }

//     @PostMapping("/register")
//     public ResponseEntity<User> register(@RequestBody User user) {
//         return ResponseEntity.ok(userService.register(user));
//     }

//     @PostMapping("/login")
//     public ResponseEntity<String> login(@RequestBody User request) {
//         User user = userService.findByEmail(request.getEmail());
//         if (user == null) {
//             return ResponseEntity.status(401).body("Invalid credentials");
//         }
//         String token = jwtProvider.generateToken(
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole()
//         );
//         return ResponseEntity.ok(token);
//     }
// }
package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User savedUser = userService.register(user);
        return "User registered with username: " + savedUser.getUsername();
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            return jwtTokenProvider.generateToken(existingUser);
        }
        return "Invalid credentials";
    }
}
