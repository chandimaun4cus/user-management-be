package com.un4cus.backend.service;

import com.un4cus.backend.dto.UserDTO;
import com.un4cus.backend.entity.UserEntity;
import com.un4cus.backend.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
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

        UserEntity existingUser = userRepository.findUserByEmail(user.getEmail());
        if(existingUser != null){
            throw new EntityExistsException("Email already exists: " + user.getEmail());
        }
        return userRepository.save(user);
    }

    // Get All Users
    public List<UserEntity> getAllUsers() {

        return userRepository.findUsersNotDeleted();

    }

    // Get user by Id
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found."));

    }

    // Update user
    public UserEntity updateUser(Long id, UserDTO updatedUser) {


        UserEntity existingUser = this.getUserById(id);

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setRole(updatedUser.getRole());
        existingUser.setStatus(updatedUser.getStatus());
        existingUser.setUserDeletedStatus(updatedUser.isUserDeletedStatus());

        return userRepository.save(existingUser);

    }

    // Delete User
    public void softDeleteUser(Long id) {
        UserEntity user = this.getUserById(id);
        user.setStatus(UserEntity.Status.INACTIVE);
        user.setUserDeletedStatus(true);
        userRepository.save(user);
    }

}
