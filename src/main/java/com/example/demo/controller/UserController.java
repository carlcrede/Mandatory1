package com.example.demo.controller;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService userService = new UserService(); // mock 'db'

    @PostMapping("api/users")
    public ResponseEntity<UserService> getUsers() {
        return ResponseEntity.ok(userService);
    }

    @PostMapping("api/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user.getUsername());
        return ResponseEntity.ok(user);
    }
}
