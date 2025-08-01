package com.un4cus.backend.service;

import com.un4cus.backend.dto.UserRequestDTO;
import com.un4cus.backend.dto.UserResponseDTO;
import com.un4cus.backend.entity.UserEntity;
import com.un4cus.backend.repository.UserRepository;
import com.un4cus.backend.transformers.UserDtoTransformer;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    private final UserDtoTransformer userDtoTransformer;


    // Create User
    public UserResponseDTO createUser(@Valid UserRequestDTO userDto) {


        if(userRepository.findUserByEmail(userDto.getEmail()) != null){
            throw new EntityExistsException("Email already exists: " + userDto.getEmail());
        }

        UserEntity userEntity = userDtoTransformer.mapToEntity(userDto);
        UserEntity savedUser = userRepository.save(userEntity);

        return userDtoTransformer.mapToResponseDTO(savedUser);
    }

    // Get All Users
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findUsersNotDeleted()
                .stream()
                .map(userDtoTransformer::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    // Get user by Id
    public UserResponseDTO getUserById(Long id) {

        UserEntity user =userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found."));
        return userDtoTransformer.mapToResponseDTO(user);

    }

//    // Update user
//    public UserRequestDTO updateUser(Long id, UserRequestDTO updatedUser) {
//
//
//        UserResponseDTO existingUser = this.getUserById(id);
//
//
//        existingUser.setFirstName(updatedUser.getFirstName());
//        existingUser.setLastName(updatedUser.getLastName());
//        existingUser.setRole(updatedUser.getRole());
//        existingUser.setStatus(updatedUser.getStatus());
//        existingUser.setUserDeletedStatus(updatedUser.isUserDeletedStatus());
//
//        return userRepository.save(existingUser);
//
//    }
//
//    // Delete User
//    public void softDeleteUser(Long id) {
//        UserResponseDTO user = this.getUserById(id);
//        user.setStatus(UserResponseDTO.Status.INACTIVE);
//        user.setUserDeletedStatus(true);
//        userRepository.save(user);
//    }


}
