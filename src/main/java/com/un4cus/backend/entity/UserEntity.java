package com.un4cus.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(schema = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(message = "First Name is required", min = 2, max = 30)
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name must only contain letters.")
    private String firstNAme;

    @NotBlank
    @Size(message = "Last Name is required", min = 2, max = 30)
    @Pattern(regexp = "^[A-Za-z]+$", message = "Last name must only contain letters.")
    private String lastName;

    @NotBlank
    @Size(min = 4, max = 20, message = "username should have length between 4 and 20 characters.")
    @Column(unique = true)
    private String username;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "Password must be minimum of 8 length with contain 1 uppercase, 1 number and 1 symbol.")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    public enum Role {
        ADMIN, USER, GUEST
    }

    public enum Status {
        ACTIVE, INACTIVE
    }

}
