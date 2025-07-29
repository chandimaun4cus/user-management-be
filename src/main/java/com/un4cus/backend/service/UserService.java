package com.un4cus.backend.service;

import com.un4cus.backend.entity.UserEntity;
import com.un4cus.backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEntity createUser(@Valid UserEntity user) {
        return userRepository.save(user);
    }

  
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }


    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

    }

 
    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        UserEntity existingUser = this.getUserById(id);
        updatedUser.setId(existingUser.getId());
        updatedUser.setCreatedDate(existingUser.getCreatedDate());
        return userRepository.save(updatedUser);
    }
    

    public void softDeleteUser(Long id) {
        UserEntity user = this.getUserById(id);
        user.setStatus(UserEntity.Status.INACTIVE);
        userRepository.save(user);
    }

}
