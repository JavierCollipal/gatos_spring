package com.example.gatos_spring.controller;

import com.example.gatos_spring.entity.User;
import com.example.gatos_spring.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("users/sign-up")
    public ResponseEntity<String> signUpUser(@Valid @RequestBody User user) {
        return userService.singUp(user);
    }
}
