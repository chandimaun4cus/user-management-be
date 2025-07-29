package com.un4cus.backend.service;

import com.un4cus.backend.entity.UserEntity;
import com.un4cus.backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    // Create User
    public UserEntity createUser(@Valid UserEntity user) {
        return userRepository.save(user);
    }

    // Get All Users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by Id
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

    }

    // Update user
    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        UserEntity existingUser = this.getUserById(id);
        updatedUser.setId(existingUser.getId());
        updatedUser.setCreatedDate(existingUser.getCreatedDate());
        return userRepository.save(updatedUser);
    }

    // Delete User
    public void softDeleteUser(Long id) {
        UserEntity user = this.getUserById(id);
        user.setStatus(UserEntity.Status.INACTIVE);
        userRepository.save(user);
    }

}
