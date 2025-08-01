package com.un4cus.backend.dto;

import com.un4cus.backend.enums.Role;
import com.un4cus.backend.enums.Status;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class UserResponseDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private Role role;

    private Status status;

    private LocalDateTime createdDate;

    private boolean userDeletedStatus;

}
