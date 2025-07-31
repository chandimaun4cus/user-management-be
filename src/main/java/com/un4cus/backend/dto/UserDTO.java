package com.un4cus.backend.dto;

import com.un4cus.backend.entity.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class UserDTO {


    @NotBlank
    @Size(message = "First Name is required", min = 2, max = 30)
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name must only contain letters.")
    private String firstName;

    @NotBlank
    @Size(message = "Last Name is required", min = 2, max = 30)
    @Pattern(regexp = "^[A-Za-z]+$", message = "Last name must only contain letters.")
    private String lastName;


    @NotNull
    @Enumerated(EnumType.STRING)
    private UserEntity.Role role;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserEntity.Status status;

    @Column(name = "User_Deleted_Status")
    private boolean userDeletedStatus;


    public enum Role {
        ADMIN, USER, GUEST
    }

    public enum Status {
        ACTIVE, INACTIVE
    }

}
