package com.ghost.backend.service;

import com.ghost.backend.pojo.User;

public interface UserService {
    User findByUsername(String username);

    void register(String username, String password, String email);
}
