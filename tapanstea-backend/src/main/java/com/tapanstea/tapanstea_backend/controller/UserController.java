package com.tapanstea.tapanstea_backend.controller;

import org.springframework.web.bind.annotation.*;
import com.tapanstea.tapanstea_backend.model.User;
import com.tapanstea.tapanstea_backend.security.JwtUtil;
import com.tapanstea.tapanstea_backend.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil=jwtUtil;
    }

    // Register a new user
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> loggedInUser = userService.login(user.getEmail(), user.getPassword());
        if (loggedInUser.isPresent()) {
            User u = loggedInUser.get();
            String token = jwtUtil.generateToken(u.getEmail(), u.getRole().name());
            return token;
        }
        return "Invalid email or password";
    }
}
