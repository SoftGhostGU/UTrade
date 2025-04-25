package com.ghost.backend.controller;

import com.ghost.backend.pojo.Result;
import com.ghost.backend.pojo.User;
import com.ghost.backend.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,20}$") String username, @Pattern(regexp = "^\\S{5,32}$") String password, String email) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return Result.error("用户名已存在");
        } else {
            userService.register(username, password, email);
            return Result.success();
        }
    }
}
