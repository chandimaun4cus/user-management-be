package com.un4cus.backend.dto;

import com.un4cus.backend.enums.Role;
import com.un4cus.backend.enums.Status;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserRequestDTO {


    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private Role role;

    private Status status;

    private boolean userDeletedStatus;


}
