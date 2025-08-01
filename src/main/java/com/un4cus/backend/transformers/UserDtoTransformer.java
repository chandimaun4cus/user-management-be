package com.un4cus.backend.transformers;

import com.un4cus.backend.dto.UserRequestDTO;
import com.un4cus.backend.dto.UserResponseDTO;
import com.un4cus.backend.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDtoTransformer                                                                                                                                               {

    // map UserRequestDTO to UserEntity
    public UserEntity mapToEntity(UserRequestDTO dto) {

        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setUsername(dto.getUsername());
        userEntity.setEmail(dto.getEmail());
        userEntity.setPassword(dto.getPassword());
        userEntity.setRole(dto.getRole());
        userEntity.setStatus(dto.getStatus());
        userEntity.setUserDeletedStatus(dto.isUserDeletedStatus());

        return userEntity;

    }

    // map UserEntity to UserResponseDTO
    public UserResponseDTO mapToResponseDTO(UserEntity user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .role(user.getRole())
                .status(user.getStatus())
                .createdDate(user.getCreatedDate())
                .userDeletedStatus(user.isUserDeletedStatus())
                .build();
    }

}
