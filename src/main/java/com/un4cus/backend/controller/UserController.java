package com.un4cus.backend.controller;

import com.un4cus.backend.dto.UserDTO;
import com.un4cus.backend.entity.UserEntity;
import com.un4cus.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Create User
    @PostMapping("/user")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity user) {
        return new ResponseEntity<> (userService.createUser(user), HttpStatus.CREATED);
    }

    // Get All Users
    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getUsers() {
        return new ResponseEntity<> (
                userService.getAllUsers(), HttpStatus.OK
        );
    }

    // Get user by Id
    @GetMapping("/user/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
        return new ResponseEntity<> (userService.getUserById(id), HttpStatus.OK);
    }

    // Update user
    @PutMapping("/user/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO user) {
        return new ResponseEntity<> (userService.updateUser(id, user), HttpStatus.ACCEPTED);
    }

    // Delete User
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> softDeleteUser(@PathVariable Long id) {
        userService.softDeleteUser(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }
}

