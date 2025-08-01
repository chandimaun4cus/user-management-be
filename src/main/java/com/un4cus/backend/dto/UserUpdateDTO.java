package com.un4cus.backend.dto;

import com.un4cus.backend.enums.Role;
import com.un4cus.backend.enums.Status;
import lombok.Data;

@Data
public class UserUpdateDTO {

    private String firstName;

    private String lastName;

    private Role role;

    private Status status;

    private boolean userDeletedStatus;

}
