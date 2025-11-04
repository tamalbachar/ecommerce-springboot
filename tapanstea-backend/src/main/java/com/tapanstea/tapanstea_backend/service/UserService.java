package com.tapanstea.tapanstea_backend.service;

import java.util.Optional;

import com.tapanstea.tapanstea_backend.model.User;

public interface UserService {

    User registerUser(User user);
    Optional<User> login(String email, String password);

}
