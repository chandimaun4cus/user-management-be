package com.un4cus.backend.controller;

import com.un4cus.backend.dto.UserRequestDTO;
import com.un4cus.backend.dto.UserResponseDTO;
import com.un4cus.backend.dto.UserUpdateDTO;
import com.un4cus.backend.entity.UserEntity;
import com.un4cus.backend.service.UserService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO user) {
        try {
            return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
        }
        catch (EntityExistsException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // Get All Users
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return new ResponseEntity<> (
                userService.getAllUsers(), HttpStatus.OK
        );
    }

    // Get user by Id
    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {

        try{
            return new ResponseEntity<> (userService.getUserById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Update user
    @PutMapping("/user/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO user) {
        try{
            UserResponseDTO updatedUser = userService.updateUser(id, user);
            return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
//
//    // Delete User
//    @DeleteMapping("/user/{id}")
//    public ResponseEntity<Void> softDeleteUser(@PathVariable Long id) {
//        userService.softDeleteUser(id);
//        return new ResponseEntity<> (HttpStatus.OK);
//    }
}

